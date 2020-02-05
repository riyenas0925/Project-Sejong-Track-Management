package kr.ac.sejong.service;

import kr.ac.sejong.domain.Degree;
import kr.ac.sejong.domain.Track;
import kr.ac.sejong.domain.Univ;
import kr.ac.sejong.persistence.DegreeRepository;
import kr.ac.sejong.persistence.TrackRepository;
import kr.ac.sejong.persistence.UnivRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class SelectListServiceImpl implements SelectListService{

    @Inject
    private UnivRepository univRepository;

    @Inject
    private TrackRepository trackRepository;

    @Inject
    private DegreeRepository degreeRepository;


    @Override
    public List<Degree> degreeList() throws Exception{
        List<Degree> degreeList = new ArrayList<>();

        degreeRepository.findAll().forEach(i -> {
            degreeList.add(i);
        });

        return degreeList;
    }

    @Override
    public List<Univ> univList() throws Exception{
        List<Univ> univList = new ArrayList<>();

        univRepository.findAll().forEach(i -> {
            univList.add(i);
        });

        return univList;
    }

    @Override
    public List<Track> trackList(Long univId) throws Exception{
        return trackRepository.findByUnivId(univId);
    }
}
