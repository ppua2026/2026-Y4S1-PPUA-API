package kh.edu.ppua.api.controller;

import jakarta.validation.Valid;
import kh.edu.ppua.api.dto.UserCreateRequest;
import kh.edu.ppua.api.exceptions.ResourceNotFoundException;
import kh.edu.ppua.api.model.UserEntity;
import kh.edu.ppua.api.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/api/v1/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public List<UserEntity> findAllUser(){
        return userRepository.findAll();
    }

    @RequestMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable long id) throws ResourceNotFoundException {
        Optional<UserEntity> userEntity = Optional.of(userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found")));
        return ResponseEntity.ok(userEntity);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateRequest request, BindingResult result){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(request.getPassword());
        userEntity.setAge(request.getAge());
        userRepository.save(userEntity);
        if(result.hasErrors()){
            return  ResponseEntity.badRequest().body(result.getAllErrors());
        }
        return ResponseEntity.ok(userEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody UserEntity userEntity){
        userEntity.setId(id);
        userEntity = userRepository.save(userEntity);
        return ResponseEntity.ok(userEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id){
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if(userEntity.isPresent()){
            userRepository.deleteById(id);
        }
        return ResponseEntity.ok(userEntity);
    }


}
