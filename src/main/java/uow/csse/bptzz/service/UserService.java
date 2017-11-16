package uow.csse.bptzz.service;

import uow.csse.bptzz.model.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);

    User findByEmail(String email);

    User findByUsernameOrEmail(String email, String username);

    void save(User user);
}