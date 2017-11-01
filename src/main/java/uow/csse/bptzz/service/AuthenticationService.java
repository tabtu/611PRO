package uow.csse.bptzz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uow.csse.bptzz.model.bptzz_User;
import uow.csse.bptzz.repository.bptzz_UserRepo;

import java.util.*;
/*
@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    private bptzz_UserRepo usrepo;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        bptzz_User user = usrepo.findByUsername(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
        return buildUserForAuthentication(user, authorities);
    }

    private User buildUserForAuthentication(bptzz_User usr, List<GrantedAuthority> authorities) {
        //return new User(usr.getUsername(), usr.getPassword(), usr.isEnabled(), true, true, true, authorities);
        return new User(usr.getUsername(), usr.getPassword(), true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        // Build user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
        return Result;
    }
}
*/