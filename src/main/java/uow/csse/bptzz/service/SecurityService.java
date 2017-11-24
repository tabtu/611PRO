package uow.csse.bptzz.service;

import uow.csse.bptzz.model.User;

/**
 * @author 	Tab Tu
 * @update	Nov.18 2017
 * @version	1.1
 */

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);

    User faceIdentify(String file);
}
