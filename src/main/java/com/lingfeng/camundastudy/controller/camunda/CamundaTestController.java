package com.lingfeng.camundastudy.controller.camunda;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.util.JSONObject1O;
import com.lingfeng.camundastudy.common.domain.Result;
import com.lingfeng.camundastudy.domain.entity.UserEntity;
import com.lingfeng.camundastudy.service.camunda.CamundaTestService;
import jakarta.annotation.Resource;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/camunda/test")
public class CamundaTestController {

    @Resource
    private RuntimeService runtimeService;

    @Resource
    private CamundaTestService camundaTestService;

    // 访问示例: http://localhost:8080/apply?name=John&day=2
    @GetMapping("/leave")
    public Result<String> applyLeave(@RequestParam String name, @RequestParam Integer day) {
        
        // 1. 准备变量 Map
        Map<String, Object> variables = new HashMap<>();
        variables.put("applicant", name);
        variables.put("day", day); // 这个 key 必须和 BPMN 连线上的 ${day} 一致
        // 存对象
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("admin");
        userEntity.setPassword("admin");
        variables.put("user", JSONObject.toJSONString(userEntity));

        // 2. 启动流程，带上 Map
        // 这里的 key 是 BPMN 文件的 ID
        runtimeService.startProcessInstanceByKey("process_leave", variables);

        return Result.ok("申请已提交，请查看控制台日志！");
    }

    @PostMapping("/startLeave")
    public Result<String> startLeave(@RequestParam String name, @RequestParam Integer day) {
        camundaTestService.startLeave(name, day);
        return Result.ok();
    }
}