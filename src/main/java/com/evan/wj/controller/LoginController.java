package com.evan.wj.controller;

import com.evan.wj.pojo.User;
import com.evan.wj.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@Controller
public class LoginController {

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
//        对 html 标签进行转义，防止 XSS 攻击
        username = HtmlUtils.htmlEscape(username);

        if (Objects.equals("admin", username) && Objects.equals("admin", requestUser.getPassword())) {
            return new Result(200);
        } else {
            return new Result(400);
        }
    }
}
