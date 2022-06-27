package com.techwondoe.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.techwondoe.entities.Role;
import com.techwondoe.entities.User;
import com.techwondoe.repositories.UserRepository;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
 
    @Autowired private UserRepository repo;
     
    @Test
    public void testCreateUser() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("admin123");
         
        User newUser = new User("admin@gmail.com", password);
        User savedUser = repo.save(newUser);
         
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
    
    @Test
    public void testAssignRoleToUser() {
        Integer userId = 3;
        Integer roleId = 2;
        User user = repo.findById(userId).get();
        user.addRole(new Role(roleId));
         
        User updatedUser = repo.save(user);
        assertThat(updatedUser.getRoles()).hasSize(1);
         
    }
}
