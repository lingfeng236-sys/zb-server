package com.lingfeng.camundastudy.controller.user;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lingfeng.camundastudy.common.annotation.security.IsAdmin;
import com.lingfeng.camundastudy.common.annotation.security.IsUserOrAdmin;
import com.lingfeng.camundastudy.common.domain.Result;
import com.lingfeng.camundastudy.domain.dto.user.UserDto;
import com.lingfeng.camundastudy.domain.dto.user.UserQueryDto;
import com.lingfeng.camundastudy.domain.dto.user.UserSaveDto;
import com.lingfeng.camundastudy.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "用户接口")
public class UserController {

    @Resource
    private UserService userService;


    @IsUserOrAdmin
    @GetMapping("/page")
    @Operation(summary = "分页查询用户")
    public Result<IPage<UserDto>> page(@ModelAttribute UserQueryDto userQueryDto) {
        return Result.ok(userService.page(userQueryDto));
    }

    @IsAdmin // 建议加上权限控制
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除用户")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.ok(userService.delete(id));
    }

    // 1. 登录接口
    @PostMapping("/login")
    public Result<String> login(@RequestBody UserSaveDto userSaveDto) {

        return Result.ok(userService.login(userSaveDto));

    }

    // 2. 新增用户
//    @IsUserOrAdmin 加了这个注解，必须要有token
    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody @Valid UserSaveDto userSaveDto) {
        userService.register(userSaveDto);
        return Result.ok();
    }

    // 3. 查询单个用户 (Retrieve One)
    @GetMapping("/get/{id}")
    public Result<UserDto> detail(@PathVariable Long id) {
        return Result.ok(userService.detail(id));
    }

    // 4. 修改用户（新增或编辑）
    @IsAdmin
    @PutMapping("/addOrEdit")
    public Result<Boolean> addOrEdit(@RequestBody UserSaveDto userSaveDto) {
        userService.addOrEdit(userSaveDto);
        return Result.ok();
    }

    @GetMapping("/info")
    @Operation(summary = "获取当前登录用户信息")
    public Result<UserDto> info() {
        UserDto userDto = userService.getCurrentUser();
        return Result.ok(userDto);
    }

    @PutMapping("/updateProfile")
    @Operation(summary = "更新个人资料")
    public Result<Boolean> updateProfile(@RequestBody UserSaveDto userSaveDto) {
        userService.updateProfile(userSaveDto);
        return Result.ok();
    }

}