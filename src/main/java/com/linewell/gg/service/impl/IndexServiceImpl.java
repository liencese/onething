package com.linewell.gg.service.impl;

import com.linewell.gg.dao.mapperwas.ApasUniteModuleMapper;
import com.linewell.gg.dao.mapperwas.module.ApasUniteModule;
import com.linewell.gg.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("indexService")
public class IndexServiceImpl implements IndexService {

    @Autowired
    private ApasUniteModuleMapper apasUniteModuleMapper;

    @Override
    public List<ApasUniteModule> getAllApasUniteModule() {
        return apasUniteModuleMapper.getAllApasUniteModule();
    }
}
