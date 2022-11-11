package com.hami.learningenglishtabasom;

import com.hami.learningenglishtabasom.entity.Role;
import com.hami.learningenglishtabasom.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {
	
	@Autowired private RoleRepository roleRepository;
	
	@Test
	public void testCreateRoles() {
		
		Role admin = new Role("ROLE_ADMIN");
		Role editor = new Role("ROLE_EDITOR");
		Role customer = new Role("ROLE_CUSTOMER");
		
		roleRepository.saveAll(List.of(admin, editor, customer));
		
		long numberOfRoles = roleRepository.count();
		assertEquals(3, numberOfRoles);
		
	}
	
	@Test
	public void testListRoles() {
		List<Role> listRoles = roleRepository.findAll();
		assertThat(listRoles.size()).isGreaterThan(0);
		
		listRoles.forEach(System.out::println);
	}

}
