package com.java.example.service;
import java.text.ParseException;
import java.util.List;

import com.java.example.exception.UserNotFoundException;
import com.java.example.model.User;
public interface RestAPIService {

    List<User> findUserByFirstName(String firstName);
    List<User> findUserByBirthday(String date) throws ParseException; //throws Exception;
    User findUser(Long id) throws UserNotFoundException;
    void updateUser(User user, Long id);
    void deleteUser(Long id);
}
