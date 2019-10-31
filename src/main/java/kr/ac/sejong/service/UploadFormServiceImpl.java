package kr.ac.sejong.service;

import kr.ac.sejong.domain_old.trackVO;
import kr.ac.sejong.domain_old.univVO;
import kr.ac.sejong.persistence_old.UploadFormDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UploadFormServiceImpl implements UploadFormService{

    @Inject
    private UploadFormDAO uploadFormDAO;

    @Override
    public List<trackVO> listTrack(Integer univNo)throws Exception{
        return uploadFormDAO.listTrack(univNo);
    }

    @Override
    public List<univVO> listUniv()throws Exception{
        return uploadFormDAO.listUniv();
    }
}
