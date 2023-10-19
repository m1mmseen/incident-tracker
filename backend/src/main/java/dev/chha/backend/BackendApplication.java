package dev.chha.backend;

import dev.chha.backend.model.IncidentCategory;
import dev.chha.backend.model.IncidentSeverity;
import dev.chha.backend.model.User;
import dev.chha.backend.model.UserRole;
import dev.chha.backend.repository.IncidentCategoryRepository;
import dev.chha.backend.repository.IncidentSeverityRepository;
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
	CommandLineRunner run(UserRoleRepository roleRepo, UserRepository userRepo, PasswordEncoder passwordEncoder, IncidentCategoryRepository inciCatRepo, IncidentSeverityRepository inciSevRepo) {
		return args -> {
			setAdmin(roleRepo, userRepo, passwordEncoder);

			setCategories(inciCatRepo);

			setSeverities(inciSevRepo);

		};
	}

	public static void setAdmin(UserRoleRepository roleRepo, UserRepository userRepo, PasswordEncoder passwordEncoder) {
		if(roleRepo.findByAuthority("ADMIN").isPresent()) return;
		UserRole adminRole = roleRepo.save(new UserRole("ADMIN"));
		roleRepo.save(new UserRole("USER"));

		Set<UserRole> roles = new HashSet<>();
		roles.add(adminRole);

		User admin = new User(1L, "admin", passwordEncoder.encode("password"), "Rüdiger", "Rust", roles);
		userRepo.save(admin);
	}

	public static void setCategories(IncidentCategoryRepository inciCatRepo) {
		if(inciCatRepo.count() > 5) return;
		inciCatRepo.save(new IncidentCategory(1,"Malware"));
		inciCatRepo.save(new IncidentCategory(2,"Phishing"));
		inciCatRepo.save(new IncidentCategory(3,"DDoS Attacks"));
		inciCatRepo.save(new IncidentCategory(4,"Unauthorised Access"));
		inciCatRepo.save(new IncidentCategory(5,"Data Leakage"));
		inciCatRepo.save(new IncidentCategory(6,"Physical Breach"));
	}

	public static void setSeverities(IncidentSeverityRepository inciSevRepo) {
		if(inciSevRepo.count() > 3) return;

		inciSevRepo.save(new IncidentSeverity(1,"Critical (P1)"));
		inciSevRepo.save(new IncidentSeverity(2,"High (P2)"));
		inciSevRepo.save(new IncidentSeverity(3,"Medium (P3)"));
		inciSevRepo.save(new IncidentSeverity(4,"Low (P4)"));

	}

}
