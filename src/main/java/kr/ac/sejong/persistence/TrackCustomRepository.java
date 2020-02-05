package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.Track;
import kr.ac.sejong.dto.TrackSubjectJoinDto;
import kr.ac.sejong.dto.TrackJudgeAllViewDto;

import java.util.List;

public interface TrackCustomRepository {
    public List<Track> findByUnivId(Long univId);
    
    public List<TrackJudgeAllViewDto> findByUnivIdDTO(Long univId);
    
    public List<TrackJudgeAllViewDto> findByTrackIdDto(Long trackId);
    
    public List<TrackJudgeAllViewDto> findByTrackIdAndDegreeIdDto(Long trackId, Long degreeId);
    
    public List<TrackJudgeAllViewDto> findByUnivIdAndTrackIdAndDegreeIdDto(Long univId, Long trackId, Long degreeId);

    public List<TrackSubjectJoinDto> standardList(Long trackId);
}
