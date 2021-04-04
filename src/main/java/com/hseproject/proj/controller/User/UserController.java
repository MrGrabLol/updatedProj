package com.hseproject.proj.controller.User;

import com.hseproject.proj.model.AuthModel;
import com.hseproject.proj.model.User;
import com.hseproject.proj.service.User.UserService;
import com.hseproject.proj.view.AuthView;
import com.hseproject.proj.view.SignUpView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth")
    public Long auth(@RequestBody AuthView authModel) {
        return userService.auth(authModel);
    }

    @PostMapping("/signUp")
    public Long signUp(@RequestBody SignUpView view) {
        return userService.signUp(view);
    }

    @GetMapping("/user")
    public User getUser(@RequestParam("id") Long id) {
        return userService.getUser(id);
    }

}
