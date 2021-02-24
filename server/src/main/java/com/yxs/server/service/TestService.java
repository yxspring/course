package com.yxs.server.service;

import com.yxs.server.domain.Test;
import com.yxs.server.mapper.TestMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public List<Test> list(){
        return testMapper.list();
    }
}
