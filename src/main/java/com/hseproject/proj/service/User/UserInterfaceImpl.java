package com.hseproject.proj.service.User;

import com.hseproject.proj.model.AuthModel;
import com.hseproject.proj.model.User;
import com.hseproject.proj.view.AuthView;
import com.hseproject.proj.view.SignUpView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

@Service
public class UserInterfaceImpl implements UserService {

    final EntityManager em;

    public UserInterfaceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Long auth(AuthView authView) {
        AuthModel model;
        TypedQuery<AuthModel> authModel = em.createQuery("SELECT a FROM auth_model a where a.login like :login and a" +
                ".password like :password", AuthModel.class);
        authModel.setParameter("password", authView.password);
        authModel.setParameter("login", authView.login);
        try {
            model = authModel.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            return -1L;
        }
        TypedQuery<User> user = em.createQuery("SELECT u FROM users u WHERE u.authModel = :authModel", User.class);
        user.setParameter("authModel", model);
        try {
            user.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            return -1L;
        }
        return user.getSingleResult().getId();
    }

    @Override
    public Long signUp(SignUpView user) {
        AuthModel model = new AuthModel(user.login, user.password);
        em.persist(model);
        User u = new User(model, user.phone);
        em.persist(u);
        return u.getId();
    }

    @Override
    public User getUser(Long id) {
        return em.find(User.class, id);
    }
}
