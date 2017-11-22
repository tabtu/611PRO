package uow.csse.bptzz.service;

import uow.csse.bptzz.model.User;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);

    User faceIdentify(String file);
}
