package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.testVO;
import kr.ac.sejong.domain.trackSubjectVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UploadResultDAOImpl implements UploadResultDAO{

    @Inject
    private SqlSession session;

    private  static String namespace = "kr.ac.sejong.mapper.uploadResultMapper";

    @Override
    public testVO readRule(Integer ruleNo) throws Exception{
        return session.selectOne(namespace+".readrule", ruleNo);
    }

    @Override
    public List<trackSubjectVO> readSub(Integer trackNo) throws Exception{
        return session.selectList(namespace+".readsub", trackNo);
    }

    @Override
    public List<trackSubjectVO> readTypeSub(Integer trackNo, Integer subType) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("trackNo", trackNo);
        params.put("subtype", subType);

        return session.selectList(namespace+".readtypesub", params);
    }
}