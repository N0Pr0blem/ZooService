package com.service.zoo.sevice;

import com.service.zoo.api.exception.AuthorizationInvalidPasswordException;
import com.service.zoo.api.exception.UserAlreadyExistException;
import com.service.zoo.api.exception.UserNotFoundException;
import com.service.zoo.api.Entity.UserEntity;
import com.service.zoo.api.model.User;
import com.service.zoo.api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity userEntity) throws UserAlreadyExistException {
        if (userRepository.findByLogin(userEntity.getLogin()) != null)
            throw new UserAlreadyExistException("Пользователь с таким логином уже существует");
        return userRepository.save(userEntity);
    }

    public UserEntity getUserById(Long id) throws UserNotFoundException {
        UserEntity findUserEntity = userRepository.findById(id).get();
        if(findUserEntity ==null){
            throw new UserNotFoundException("Пользователя не существует");
        }
        return findUserEntity;
    }

    public Long deleteUserById(Long id) {
        userRepository.deleteById(id);
        return id;
    }

    public UserEntity atthorization(User user) throws AuthorizationInvalidPasswordException, UserNotFoundException {
        UserEntity findUserEntity = userRepository.findByLogin(user.getLogin());
        if(findUserEntity ==null){
            throw new UserNotFoundException("Пользователя с таким логином не существует");
        }
        if(!findUserEntity.getPassword().equals(user.getPassword())){
            throw new AuthorizationInvalidPasswordException("Неверный пароль");
        }
        return findUserEntity;
    }

    public ArrayList<UserEntity> getAllUsers() {
        return (ArrayList<UserEntity>) userRepository.findAll();
    }
}
