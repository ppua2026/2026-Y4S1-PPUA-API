package kh.edu.ppua.api.controller;

import kh.edu.ppua.api.model.UserEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping( "/api/v1/users")
public class UserController {

    List<UserEntity> userEntities = new ArrayList<>();

    @GetMapping()
    public List<UserEntity> findAllUser(){
        return userEntities;
    }

    @RequestMapping("/{id}")
    public UserEntity findUserById(@PathVariable long id){
        Optional<UserEntity> userEntity = userEntities.stream().filter((o)-> o.getId() == id).findFirst();
        return userEntity.get();
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        userEntities.add(userEntity);
        return userEntity;
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable long id, @RequestBody UserEntity userEntity){
       Optional<UserEntity> user = userEntities.stream().filter((o) -> o.getId()==id).findFirst();
       System.out.println(user.get());
       userEntities.remove(user.get());
       userEntities.add(userEntity);
        return userEntity;
    }

    @DeleteMapping("/{id}")
    public UserEntity deleteUser(@PathVariable long id){
        Optional<UserEntity> user = userEntities.stream().filter((o) -> o.getId()==id).findFirst();
        userEntities.remove(user.get());
        return user.get();
    }


}
