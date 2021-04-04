package com.hseproject.proj.service.User;


import com.hseproject.proj.view.AuthView;
import com.hseproject.proj.view.SignUpView;
import com.hseproject.proj.view.UserView;

public interface UserService {

    Long auth(AuthView authModel);

    Long signUp(SignUpView user);

    UserView getUser(Long id);
}
