package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.Config.Exceptions.RecordNotFoundException;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Entities.UserEntity;
import com.example.demo.Mappers.UserMapper;
import com.example.demo.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        List<UserEntity> userList = repository.findAll();

        if (userList.size() > 0) {
            return userMapper.userListDTO(userList);
        } else {
            return new ArrayList<>();
        }
    }

    //    login
    public Boolean login(String email, String password) throws RecordNotFoundException {

        Optional<UserEntity> user = repository.findByEmail(email);

        if (user.isPresent()) {
            UserEntity checkUser = user.get();

            return checkUser.getPassword().equals(password);
        } else {
            throw new RecordNotFoundException("User with email" + email + "was not found.");
        }

    }

    public UserDTO getUserById(Long id) throws RecordNotFoundException {
        Optional<UserEntity> user = repository.findById(id);

        if (user.isPresent()) {
            return userMapper.userDTO(user.get());
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }

    public UserEntity createOrUpdateUser(UserEntity entity) throws RecordNotFoundException {
        if (entity.getId() != null) {
            Optional<UserEntity> user = repository.findById(entity.getId());

            UserEntity newEntity = user.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setName(entity.getName());
            newEntity.setSurname(entity.getSurname());
            newEntity.setPassword(entity.getPassword());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteUserById(Long id) throws RecordNotFoundException {
        Optional<UserEntity> user = repository.findById(id);

        if (user.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }
}