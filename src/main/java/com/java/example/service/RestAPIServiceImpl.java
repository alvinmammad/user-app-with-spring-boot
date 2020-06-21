package com.java.example.service;

import com.java.example.dao.UserRepository;
import com.java.example.exception.UserNotFoundException;
import com.java.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional
public class RestAPIServiceImpl implements RestAPIService {
    @Autowired
    private UserRepository userRepository;


//    @Override
//    public User findUser(String firstName) {
//        if (firstName == null)
//            return (User) userRepository.findAll();
//        else
//            return (User) userRepository.findUser(firstName);
//    }

    @Override
    public List<User> findUserByFirstName(String firstName) {
        return userRepository.findUserByFirstName(firstName);
    }

    @Override
    public List<User> findUserByBirthday(String birthDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = formatter.parse(birthDate);
            System.out.println(date);
            System.out.println(formatter.format(date));
            return userRepository.findByBirthDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findUser(Long id) throws UserNotFoundException {
        User user = userRepository.getOne(id);
        if (user == null)
            throw new UserNotFoundException("User not found this id: " + id);
        return user;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user, Long id) {
        User userFromDb = userRepository.getOne(id);
        userFromDb.setBirthDate(user.getBirthDate());
        userFromDb.setCitizen(user.getCitizen());
        userFromDb.setFirstName(user.getFirstName());
        userFromDb.setLastName(user.getLastName());
        userFromDb.setRegion(user.getRegion());
        System.out.println("saved user" + userFromDb.toString());
        userRepository.save(userFromDb);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.getOne(id);
        userRepository.delete(user);
    }

}
