package com.lingfeng.camundastudy.controller.common;

import com.lingfeng.camundastudy.common.domain.Result;
import com.lingfeng.camundastudy.domain.common.DictDto;
import com.lingfeng.camundastudy.service.common.EnumService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "枚举接口")
@RestController
@RequestMapping("/enum")
public class EnumController {

    @Resource
    private EnumService enumService;

    @RequestMapping("/obtainByDictType")
    public Result<List<DictDto>> obtainByDictType(@RequestParam String dictType) {
        return Result.ok(enumService.obtainByDictType(dictType));
    }
}
