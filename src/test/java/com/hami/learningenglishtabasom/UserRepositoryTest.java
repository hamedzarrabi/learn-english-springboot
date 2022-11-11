package com.hami.learningenglishtabasom;

import com.hami.learningenglishtabasom.entity.Role;
import com.hami.learningenglishtabasom.entity.User;
import com.hami.learningenglishtabasom.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void testCreateUser() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPasswordString = "hamed3d";
		String encodedPassword = passwordEncoder.encode(rawPasswordString);
		
		User newUser = new User("hamed", "zarrabi","hamed.zarrabi2023@gmail.com", "09124431480", encodedPassword);
		
		User savedUser =  userRepository.save(newUser);
		
		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testAssignRolesToUser() {
		Long userId = 5L;
		Long roleId = 1L;
		
		User user = userRepository.findById(userId).get();
		user.addRole(new Role(roleId));
		
		User updateUser = userRepository.save(user);
		
		assertThat(updateUser.getRoles());
	}
	
}