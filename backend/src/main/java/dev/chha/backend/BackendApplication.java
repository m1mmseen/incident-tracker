package dev.chha.backend;

import dev.chha.backend.model.User;
import dev.chha.backend.model.UserRole;
import dev.chha.backend.repository.UserRepository;
import dev.chha.backend.repository.UserRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRoleRepository roleRepo, UserRepository userRepo, PasswordEncoder passwordEncoder) {
		return args -> {
			if(roleRepo.findByAuthority("ADMIN").isPresent()) return;
			UserRole admineRole = roleRepo.save(new UserRole("ADMIN"));
			roleRepo.save(new UserRole("USER"));

			Set<UserRole> roles = new HashSet<>();
			roles.add(admineRole);

			User admin = new User(1L, "admin", passwordEncoder.encode("password"), "Rüdiger", "Rust", roles);
			userRepo.save(admin);

		};
	}

}
