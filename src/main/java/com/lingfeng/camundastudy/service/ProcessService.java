package com.lingfeng.camundastudy.service;

import com.lingfeng.camundastudy.common.constant.CamundaConstants;
import jakarta.annotation.Resource;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.repository.Deployment;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {

    @Resource
    private RepositoryService repositoryService;

    public String deploy(String processCode) {
        Deployment deployment = repositoryService.createDeployment()
                .name(processCode)
                .addClasspathResource("bpmn/" + processCode + CamundaConstants.PROCESS_FILE_SUFFIX)
                .deploy();
        return deployment.getId();
    }
}
