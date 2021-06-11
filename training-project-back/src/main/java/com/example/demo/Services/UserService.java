package com.example.demo.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.Config.Exceptions.RecordNotFoundException;
import com.example.demo.Entities.UserEntity;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserEntity> getAllUsers()
    {
        List<UserEntity> userList = repository.findAll();

        if(userList.size() > 0) {
            return userList;
        } else {
            return new ArrayList<>();
        }
    }

    public UserEntity getUserById(Long id) throws RecordNotFoundException
    {
        Optional<UserEntity> user = repository.findById(id);

        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }

    public UserEntity createOrUpdateUser(UserEntity entity) throws RecordNotFoundException
    {
        if (entity.getId() != null) {
            Optional<UserEntity> user = repository.findById(entity.getId());

            UserEntity newEntity = user.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setPassword(entity.getPassword());

            newEntity = repository.save(newEntity);

            return newEntity;
        }
        else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteUserById(Long id) throws RecordNotFoundException
    {
        Optional<UserEntity> user = repository.findById(id);

        if(user.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }
}