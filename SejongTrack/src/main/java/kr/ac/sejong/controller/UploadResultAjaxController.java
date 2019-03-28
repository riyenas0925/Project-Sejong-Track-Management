package kr.ac.sejong.controller;

import kr.ac.sejong.domain.resultTrackVO;
import kr.ac.sejong.domain.subjectVO;
import kr.ac.sejong.domain.trackVO;
import kr.ac.sejong.service.UploadFormService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/uploadAjax/*")
public class UploadResultAjaxController {

    @Inject
    private UploadFormService uploadFormService;

    @GetMapping("/univList/{univNo}")
    public ResponseEntity<List<trackVO>> list(@PathVariable Integer univNo){

        ResponseEntity<List<trackVO>> entity = null;

        try {
            entity = new ResponseEntity<>(uploadFormService.listTrack(univNo), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}