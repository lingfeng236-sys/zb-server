package com.lingfeng.camundastudy.common.domain;

import lombok.Data;

@Data
public class BasePageDto {
    private Integer pageNum = 1;
    private Integer pageSize = 20;

}
