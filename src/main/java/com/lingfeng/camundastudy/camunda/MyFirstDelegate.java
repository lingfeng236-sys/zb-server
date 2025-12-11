package com.lingfeng.camundastudy.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("myFirstDelegate") // 这里的名字必须和图里填的一样！
public class MyFirstDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("==================================");
        System.out.println("恭喜你！Camunda 调用了你的 Java 代码！");
        System.out.println("==================================");
    }
}