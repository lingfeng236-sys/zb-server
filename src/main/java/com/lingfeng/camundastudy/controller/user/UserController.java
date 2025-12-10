package com.lingfeng.camundastudy.controller.user;


import com.lingfeng.camundastudy.common.domain.Result;
import com.lingfeng.camundastudy.domain.dto.user.UserSaveDto;
import com.lingfeng.camundastudy.domain.entity.UserEntity;
import com.lingfeng.camundastudy.service.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    // 1. 登录接口
    @PostMapping("/login")
    public Result<String> login(@RequestBody UserSaveDto userSaveDto) {

        return Result.ok(userService.login(userSaveDto));

    }

    // 2. 新增用户
    @PostMapping("/register")
    public Result<Boolean> add(@RequestBody UserSaveDto userSaveDto) {

        userService.register(userSaveDto);
        return Result.ok();
    }

    /*// 3. 删除用户 (Delete)
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        boolean success = userService.removeById(id);
        return success ? "删除成功" : "删除失败";
    }

    // 4. 修改用户 (Update)
    @PutMapping("/update")
    public String update(@RequestBody User user) {
        boolean success = userService.updateById(user);
        return success ? "修改成功" : "修改失败";
    }

    // 5. 查询单个用户 (Retrieve One)
    @GetMapping("/get/{id}")
    public User get(@PathVariable Long id) {
        return userService.getById(id);
    }

    // 6. 查询所有用户 (Retrieve All)
    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }*/
}