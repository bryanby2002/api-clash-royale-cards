package com.project.cr.service;

import com.project.cr.model.UserModel;
import com.project.cr.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    public UserDetailsServiceImpl(UserRepository userRepository){this.userRepository= userRepository;}
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findUserModelByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("El user "+username+" no existe"));
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        userModel.getRoles()
                .forEach(role -> authorityList.add(
                        new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))
                ));

        userModel.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .forEach(permision -> authorityList.add(
                        new SimpleGrantedAuthority(permision.getName())
                ));

        return new User(userModel.getUserName(),
                userModel.getPassword(),
                userModel.isEnable(),
                userModel.isAccountNoExpired(),
                userModel.isCredentialNoExpired(),
                userModel.isAccountNoLocked(),
                authorityList);
    }
}
