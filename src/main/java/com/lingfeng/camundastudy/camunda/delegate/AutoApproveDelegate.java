package com.lingfeng.camundastudy.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("autoApproveDelegate")
public class AutoApproveDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // 1. 【读取】流程变量 (Get)
        // 注意：Camunda 里的数字默认可能是 Integer 或 Long，建议先转 Object 再强转，或者由调用方保证类型
        String name = (String) execution.getVariable("applicant");
        Integer day = (Integer) execution.getVariable("day");

        System.out.println("--- 触发自动审批逻辑 ---");
        System.out.println("申请人: " + name);
        System.out.println("天数: " + day);

        // 2. 模拟业务逻辑
        System.out.println("系统检测：天数小于等于3，直接通过！");

        // 3. 【写入】新的变量 (Set)
        // 这个变量可以在后续的节点、或者历史记录中查到
        execution.setVariable("approveStatus", "AUTO_PASSED");
        execution.setVariable("approveTime", java.time.LocalDateTime.now().toString());
    }
}