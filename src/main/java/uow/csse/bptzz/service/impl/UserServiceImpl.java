package uow.csse.bptzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uow.csse.bptzz.model.bptzz_User;
import uow.csse.bptzz.repository.bptzz_UserRepo;
//import uow.csse.bptzz.service.UserService;

import java.util.HashSet;

/*
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private bptzz_UserRepo userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(bptzz_User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public bptzz_User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
*/