package ru.ld.Manager.service;

import ru.ld.Manager.model.User;
import ru.ld.Manager.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
    public void update(User user) {
        userRepository.update(user);
    }
    public User getUser(int id) {
        return userRepository.getUser(id);
    }
}
