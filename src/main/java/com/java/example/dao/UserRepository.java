package com.java.example.dao;

import com.java.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUserByFirstName(String firstName);

    List<User> findByBirthDate(Date birthDate);

}
