package kh.edu.ppua.api.controller;

import jakarta.validation.Valid;
import kh.edu.ppua.api.dto.UserCreateRequest;
import kh.edu.ppua.api.exceptions.ResourceNotFoundException;
import kh.edu.ppua.api.model.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public ResponseEntity<?> findUserById(@PathVariable long id) throws ResourceNotFoundException {
        Optional<UserEntity> userEntity = Optional.of(userEntities.stream().filter((o) -> o.getId() == id).findFirst().orElseThrow(() -> new ResourceNotFoundException("User not found")));
        return ResponseEntity.ok(userEntity);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateRequest request, BindingResult result){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(request.getPassword());
        userEntity.setAge(request.getAge());
        userEntities.add(userEntity);

        if(result.hasErrors()){
            return  ResponseEntity.badRequest().body(result.getAllErrors());
        }

        int i = 10 / 0;

        return ResponseEntity.ok(userEntity);
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
