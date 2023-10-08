package com.service.zoo.sevice;

import com.service.zoo.api.exception.UserAlreadyExistException;
import com.service.zoo.api.exception.UserNotFoundException;
import com.service.zoo.api.model.User;
import com.service.zoo.api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registration(User user) throws UserAlreadyExistException {
        if (userRepository.findByLogin(user.getLogin()) != null)
            throw new UserAlreadyExistException("Пользователь с таким логином уже существует");
        return userRepository.save(user);
    }

    public User getUserById(Long id) throws UserNotFoundException {
        User findUser = userRepository.findById(id).get();
        if(findUser==null){
            throw new UserNotFoundException("Пользователя не существует");
        }
        return findUser;
    }
}
