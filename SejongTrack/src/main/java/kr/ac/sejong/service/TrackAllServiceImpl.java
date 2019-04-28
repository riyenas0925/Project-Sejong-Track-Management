package kr.ac.sejong.service;

import kr.ac.sejong.domain.trackAllVO;
import kr.ac.sejong.persistence.TrackAllDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TrackAllServiceImpl implements TrackAllService {
    @Inject
    private TrackAllDAO dao;

    @Override
    public List<trackAllVO> trackAll(Integer univNo)throws Exception{
        List<trackAllVO> trackAllVOList = dao.trackAllList(univNo);

        return trackAllVOList;
    }
}