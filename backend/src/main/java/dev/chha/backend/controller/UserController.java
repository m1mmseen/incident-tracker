package dev.chha.backend.controller;

import dev.chha.backend.dto.SortRequestDto;
import dev.chha.backend.dto.UserDto;
import dev.chha.backend.model.User;
import dev.chha.backend.repository.UserRepository;
import dev.chha.backend.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserDetails(@PathVariable Long userId,
                                         @RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.substring("Bearer ".length());

        Long UserId = tokenService.extractUserIdFromToken(token);

        if (!(UserId.equals(userId))) {
            return new ResponseEntity<>("Not authorized to access this data", HttpStatus.FORBIDDEN);
        }

        Optional<User> userOpt = userRepo.findById(userId);

        if(userOpt.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        User user = userOpt.get();

        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setUserId(userId);
        dto.setFirstname(user.getFirstname());
        dto.setLastname(user.getLastname());
        dto.setAssignedIncidents(user.getIncidents().size());
        dto.setRoles((Collection<GrantedAuthority>) user.getAuthorities());

        return new ResponseEntity<>(dto, HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<User>> getAllUsers() {

        Iterable<User> users = userRepo.findAll(Sort.by(Sort.Direction.ASC, "lastname"));

        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @PostMapping("/customSort")
    public ResponseEntity<?> getAllUsers(@RequestBody SortRequestDto sortRequest) {

        String sort = sortRequest.getSorting();

        if ("userId".equals(sort)) {
            Iterable<User> users = userRepo.findAll(Sort.by(Sort.Direction.ASC, "userId"));
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else if ("username".equals(sort)) {
            Iterable<User> users = userRepo.findAll(Sort.by(Sort.Direction.ASC, "username"));
            return new ResponseEntity<>(users, HttpStatus.OK);
        }else if ("firstname".equals(sort)) {
            Iterable<User> users = userRepo.findAll(Sort.by(Sort.Direction.ASC, "firstname"));
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else if ("lastname".equals(sort)) {
            Iterable<User> users = userRepo.findAll(Sort.by(Sort.Direction.ASC, "lastname"));
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else if ("role".equals(sort)) {
            Iterable<User> users = userRepo.findAll(Sort.by(Sort.Direction.ASC, "role"));
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

        return new ResponseEntity<>("Sorting ID not found", HttpStatus.BAD_REQUEST);

    }
}
