//package com.java.example.dao;
//
//import com.java.example.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import java.util.Date;
//import java.util.List;
//
//// buna ehtiac yoxdu eslinde
////@Repository("userRepository")
//public class UserRepositoryImpl implements UserRepository  {
////    @PersistenceContext
////    private EntityManager entityManager;
//    @Autowired
//    private  UserRepository userRepository;
//
//    @Override
//    public List<User> findAll() {
//        return userRepository.findAll();
//        //        return entityManager.createQuery("from User", User.class).getResultList();
//    }
//
//    @Override
//    public User findByID(Long id) {
//        return userRepository.findByID(id);
//        //        return entityManager.find(User.class, id);
//    }
//
//    @Override
//    public List<User> findUserByFirstName(String firstName) {
//        return userRepository.findUserByFirstName(firstName);
//        //        return (User) entityManager.createQuery("from User where lastName = :lastName", User.class)
////                .setParameter("lastName", lastName).getResultList();
//    }
//
//    @Override
//    public List<User> findByBirthday(Date birthDate) {
//        return userRepository.findByBirthday(birthDate);
//    }
//
//    @Override
//    public void create(User user) {
//        userRepository.save(user);
////        entityManager.persist(user);
//    }
//
//    @Override
//    public void update(User user,Long id) {
//        User userFromDb = userRepository.getOne(id);
//        userFromDb.setBirthDate(user.getBirthDate());
//        userFromDb.setCitizen(user.getCitizen());
//        userFromDb.setFirstName(user.getFirstName());
//        userFromDb.setLastName(user.getLastName());
//        userFromDb.setRegion(user.getRegion());
//        userRepository.save(userFromDb);
//        //        return entityManager.merge(user);
//    }
//
//    @Override
//    public void delete(Long id) {
//        userRepository.delete(id);
//        //        entityManager.remove(entityManager.getReference(User.class, id));
//    }
//}
