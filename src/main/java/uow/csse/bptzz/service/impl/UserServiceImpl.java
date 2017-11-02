package uow.csse.bptzz.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import uow.csse.bptzz.model.Role;
import uow.csse.bptzz.model.User;
import uow.csse.bptzz.repository.RoleRepo;
import uow.csse.bptzz.repository.UserRepo;
import uow.csse.bptzz.service.UserService;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User findByUsernameOrEmail(String email, String username) { return userRepo.findByUsernameOrEmail(email, username); }

    @Override
    public User findByEmail(String email) { return userRepo.findByEmail(email); }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>());
        userRepo.save(user);
    }
}
