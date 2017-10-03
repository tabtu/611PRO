package uow.csse.bptzz.integrate;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    public UserService() {
        System.out.println("UserService Constructor...");
    }

    public void save() {
        System.out.println("save");
    }
}