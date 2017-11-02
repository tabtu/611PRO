package uow.csse.bptzz.service;

import uow.csse.bptzz.model.User;

public interface UserService {
    User findByUsername(String username);

    void save(User user);
}