package com.project.cr;

import com.project.cr.model.PermissionModel;
import com.project.cr.model.RoleEnum;
import com.project.cr.model.RoleModel;
import com.project.cr.model.UserModel;
import com.project.cr.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ApiClashRoyaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiClashRoyaleApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository){
        return args -> {

            // creacion de los roles
            PermissionModel createPremission = PermissionModel.builder().name("CREATE").build();
            PermissionModel updatePremission = PermissionModel.builder().name("UPDATE").build();
            PermissionModel readPremission = PermissionModel.builder().name("READ").build();
            PermissionModel deletePremission = PermissionModel.builder().name("DELETE").build();

            // creacion de los roles
            RoleModel roleAdmin = RoleModel.builder()
                    .roleEnum(RoleEnum.ADMIN)
                    .permissions(Set.of(
                            createPremission,
                            readPremission
                    ))
                    .build();
            RoleModel roleUser = RoleModel.builder()
                    .roleEnum(RoleEnum.USER)
                    .permissions(Set.of(
                            readPremission
                    ))
                    .build();
            RoleModel roleDeveloper = RoleModel.builder()
                    .roleEnum(RoleEnum.DEVELOPER)
                    .permissions(Set.of(
                            createPremission,
                            readPremission,
                            updatePremission,
                            deletePremission
                    ))
                    .build();

            //creacio  de usuarios
            UserModel userBryan = UserModel.builder()
                    .userName("bryan")
                    .password(new BCryptPasswordEncoder().encode("root"))
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .isEnable(true)
                    .roles(Set.of(roleDeveloper))
                    .build();

            UserModel userPedro = UserModel.builder()
                    .userName("pedro")
                    .password(new BCryptPasswordEncoder().encode("root"))
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .isEnable(true)
                    .roles(Set.of(roleAdmin))
                    .build();

            UserModel userMaria = UserModel.builder()
                    .userName("maria")
                    .password(new BCryptPasswordEncoder().encode("root"))
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .isEnable(true)
                    .roles(Set.of(roleUser))
                    .build();
            userRepository.saveAll(List.of(userBryan,userPedro, userMaria));

        };
    }

}
