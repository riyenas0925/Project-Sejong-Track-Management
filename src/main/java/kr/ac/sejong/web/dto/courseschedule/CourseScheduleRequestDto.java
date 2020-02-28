package kr.ac.sejong.web.dto.courseschedule;

import kr.ac.sejong.domain.courseSchedule.CourseSchedule;
import kr.ac.sejong.web.dto.subject.SubjectRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
public class CourseScheduleRequestDto {
    private String name;
    private List<SubjectRequestDto> subjects;

    @Builder
    public CourseScheduleRequestDto(String name, List<SubjectRequestDto> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public CourseSchedule toEntity() {
        return CourseSchedule.builder()
                .name(name)
                .subjects(subjects.stream()
                        .map(SubjectRequestDto::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
