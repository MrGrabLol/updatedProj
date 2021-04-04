package com.hseproject.proj.service.User;

import com.hseproject.proj.model.AuthModel;
import com.hseproject.proj.model.User;
import com.hseproject.proj.view.AuthView;
import com.hseproject.proj.view.SignUpView;

public interface UserService {

    Long auth(AuthView authModel);

    Long signUp(SignUpView user);

    User getUser(Long id);
}
