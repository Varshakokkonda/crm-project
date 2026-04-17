package com.crm.crm_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.crm.crm_backend.entity.User;
import com.crm.crm_backend.repository.UserRepository;

@SpringBootApplication
public class CrmBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner seedAdminUser(UserRepository userRepository) {
		return args -> {
			seedUser(userRepository, "admin", "admin123", "ADMIN");
			seedUser(userRepository, "sales1", "sales123", "SALES");
			seedUser(userRepository, "sales2", "sales123", "SALES");
			seedUser(userRepository, "support", "support123", "SUPPORT");
		};
	}

	private void seedUser(UserRepository userRepository, String username, String password, String role) {
		// Changed: keep demo role accounts aligned with the latest access rules on every startup.
		User user = userRepository.findByUsername(username);
		if (user == null) {
			user = new User();
			user.setUsername(username);
		}
		user.setPassword(password);
		user.setRole(role);
		userRepository.save(user);
	}
}
