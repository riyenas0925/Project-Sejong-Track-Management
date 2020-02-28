package kr.ac.sejong;

import kr.ac.sejong.domain.subject.Subject;
import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.trackJudge.TrackStatistic;
import kr.ac.sejong.domain.tracksubject.TrackSubject;
import kr.ac.sejong.service.TrackJudgeService;
import kr.ac.sejong.web.dto.trackjudge.SubjectStatisticDto;
import kr.ac.sejong.web.dto.excel.ExcelDto;
import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import kr.ac.sejong.web.dto.subject.SubjectRequestDto;
import kr.ac.sejong.web.dto.tracksubject.TrackSubjectDto;
import kr.ac.sejong.web.dto.tracksubject.TrackSubjectResponseDto;
import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class TrackJudgeTest{

    @Autowired
    private TrackJudgeService trackJudgeService;

    List<ReportCardExcelDto> reportCardExcelSubjects;
    List<TrackSubjectDto> standardSubjects;
    MultipartFile multipartFile;

    @Before
    public void befor() throws IOException {
        String fileName = "testCardReport.xls";
        String filePath = "src/test/resources/testCardReport.xls";

        multipartFile = new MockMultipartFile(fileName, new FileInputStream(new File(filePath)));

        reportCardExcelSubjects = new ExcelDto(multipartFile).toReportCardExcelDtos();
        standardSubjects = trackJudgeService.findByTrackId(1L).stream()
                .map(TrackSubjectResponseDto::toTrackSubjectDto)
                .collect(Collectors.toList());
    }

    @Test
    public void 트랙_하나만_판단() {
        long start = System.currentTimeMillis();

        List<TrackStatistic> trackStatistics = trackJudgeService.trackJudge(reportCardExcelSubjects, standardSubjects);

        long end = System.currentTimeMillis();
        System.out.println("실행시간 : " + (end - start) / 10000.0 + "초");

        log.info(trackStatistics.toString());
    }

    @Test
    public void 트랙_전부_판단() {
        List<TrackSubjectDto>[] test = new List[]{
                trackJudgeService.findByTrackId(1L).stream()
                        .map(TrackSubjectResponseDto::toTrackSubjectDto)
                        .collect(Collectors.toList()),

                trackJudgeService.findByTrackId(2L).stream()
                        .map(TrackSubjectResponseDto::toTrackSubjectDto)
                        .collect(Collectors.toList())
        };

        log.info(trackJudgeService.trackJudge(reportCardExcelSubjects, test).toString());
    }

    @Test
    public void 과목_분류_메서드_테스트() {

        List<Subject> reportCardSubjects = reportCardExcelSubjects.stream()
                .map(ReportCardExcelDto::toSubjectDto)
                .map(SubjectRequestDto::toEntity)
                .collect(Collectors.toList());


        Map<TrackSubject.Type, Map<TrackStatistic.PNP, SubjectStatisticDto>> classifySubjects = standardSubjects.stream()
                .collect(
                        Collectors.groupingBy(TrackSubjectDto::getSubjectType,
                                Collectors.groupingBy(trackSubjectDto -> {
                                            if(trackSubjectDto.getSubject().toSubjectDto().isContain(reportCardSubjects)){
                                                return TrackStatistic.PNP.PASS;
                                            } else {
                                                return TrackStatistic.PNP.NON_PASS;
                                            }
                                        }
                                        ,Collectors.collectingAndThen(Collectors.toList(), list -> {
                                            return new SubjectStatisticDto(
                                                    list.stream().collect(Collectors.toList()),
                                                    list.stream().collect(Collectors.summingLong(test -> {
                                                        return test.getSubject().getCredit();
                                                    }))
                                            );
                                        })
                                )
                        ));

        log.info(classifySubjects.toString());
    }
}
