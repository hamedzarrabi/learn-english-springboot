package com.hami.learningenglishtabasom.repository;


import com.hami.learningenglishtabasom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);

//    @Query("select * from User u where u.email =: email")
//    select * from user u where u.email = :email
    Optional<User> findByEmail(String email);

    boolean findByPassword(String password);
}
