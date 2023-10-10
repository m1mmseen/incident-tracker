package dev.chha.backend.services;


import dev.chha.backend.model.UserRole;
import dev.chha.backend.dto.LoginResponseDto;
import dev.chha.backend.dto.UserDto;
import dev.chha.backend.model.UserRole;
import dev.chha.backend.model.User;
import dev.chha.backend.repository.UserRoleRepository;
import dev.chha.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private UserRepository userRepo;


    @Autowired
    private UserRoleRepository roleRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public User registerUser(String username, String password, String firstname, String lastname) {
        String encodedPassword = encoder.encode(password);

        UserRole userRole = roleRepo.findByAuthority("USER").get();

        Set<UserRole> authorities = new HashSet<>();
        authorities.add(userRole);

        return userRepo.save(new User(0L, username, encodedPassword, firstname, lastname, authorities));
    }

    public LoginResponseDto loginUser(String username, String password) {

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            User userOpt = userRepo.findByUsername(username).get();


            UserDto user = new UserDto();
            user.setUserId(userOpt.getUserId());
            user.setUsername(userOpt.getUsername());
            user.setRoles((Collection<GrantedAuthority>) userOpt.getAuthorities());
            user.setFirstname(userOpt.getFirstname());
            user.setLastname(userOpt.getLastname());

            return new LoginResponseDto(user, token);

        } catch (AuthenticationException e) {
            return new LoginResponseDto(null, "");
        }

    }
}
