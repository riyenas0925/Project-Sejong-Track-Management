package kr.ac.sejong;

import kr.ac.sejong.domain.Subject;
import kr.ac.sejong.domain.Track;
import kr.ac.sejong.domain.TrackSubject;
import kr.ac.sejong.persistence.SubjectRepository;
import kr.ac.sejong.persistence.TrackRepository;
import kr.ac.sejong.persistence.TrackSubjectRepository;

import lombok.extern.java.Log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class TrackSubjectTest {

    @Inject private TrackSubjectRepository trackSubjectRepository;
    @Inject private TrackRepository trackRepository;
    @Inject private SubjectRepository subjectRepository;

    @Test
    public void createTrackSubject() {
        Long trackId = 5L;
        Long subjectId = 10L;
        Long subjectType = 1L;

        Track track = trackRepository.getOne(trackId);
        Subject subject = subjectRepository.getOne(subjectId);

        TrackSubject trackSubject = TrackSubject.createTrackSubject(track, subject, subjectType);

        trackSubjectRepository.save(trackSubject);
    }

    @Test
    @Transactional
    public void updateTrackSubject() {
        Long trackSubjectId = 20L;
        Long trackId = 5L;
        Long subjectId = 10L;
        Long subjectType = 3L;

        Track track = trackRepository.getOne(trackId);
        Subject subject = subjectRepository.getOne(subjectId);

        TrackSubject trackSubject = trackSubjectRepository.getOne(trackSubjectId);
        trackSubject.updateTrackSubject(trackSubjectId, track, subject, subjectType);

        trackSubjectRepository.save(trackSubject);
    }

    @Test
    public void deleteTrackSubject() {
        Long trackSubjectId = 5L;

        trackSubjectRepository.deleteById(trackSubjectId);
    }
}
