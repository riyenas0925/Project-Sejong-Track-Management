package kr.ac.sejong.domain.Track;

import kr.ac.sejong.web.dto.TrackAllViewDto;

import java.util.List;

public interface TrackAllDAO {
    public List<TrackAllViewDto> trackAllList(Integer univId) throws Exception;
}
