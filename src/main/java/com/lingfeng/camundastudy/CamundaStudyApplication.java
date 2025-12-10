package com.lingfeng.camundastudy;

import jakarta.annotation.Resource;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
//@EnableProcessApplication
@MapperScan("com.lingfeng.camundastudy.dao.mapper")
public class CamundaStudyApplication {

    @Resource
    private RuntimeService runtimeService;

    public static void main(String[] args) {
        SpringApplication.run(CamundaStudyApplication.class, args);
    }

//    @EventListener
//    private void processPostDeploy(PostDeployEvent event) {
//        runtimeService.startProcessInstanceByKey("loanApproval");
//    }
}
