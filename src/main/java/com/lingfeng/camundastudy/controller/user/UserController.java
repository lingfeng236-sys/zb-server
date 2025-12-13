package com.lingfeng.camundastudy.controller.user;


import com.lingfeng.camundastudy.common.annotation.security.IsOwnerOrAdmin;
import com.lingfeng.camundastudy.common.annotation.security.IsUserOrAdmin;
import com.lingfeng.camundastudy.common.domain.Result;
import com.lingfeng.camundastudy.domain.dto.user.UserDto;
import com.lingfeng.camundastudy.domain.dto.user.UserSaveDto;
import com.lingfeng.camundastudy.service.user.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "用户接口")
public class UserController {

    @Resource
    private UserService userService;


    // 场景：修改用户密码
    // 只有管理员，或者用户自己（username匹配）才能修改
    @IsOwnerOrAdmin
    @PutMapping("/updatePassword")
    public Result<Boolean> updatePassword(@RequestParam String username, @RequestParam String newPwd) {
        return Result.ok();
    }

    // 1. 登录接口
    @PostMapping("/login")
    public Result<String> login(@RequestBody UserSaveDto userSaveDto) {

        return Result.ok(userService.login(userSaveDto));

    }

    // 2. 新增用户
    @IsUserOrAdmin
    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody UserSaveDto userSaveDto) {
        userService.register(userSaveDto);
        return Result.ok();
    }

    // 3. 查询单个用户 (Retrieve One)
    @GetMapping("/get/{id}")
    public Result<UserDto> detail(@PathVariable Long id) {
        return Result.ok(userService.detail(id));
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



    // 6. 查询所有用户 (Retrieve All)
    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }*/
}