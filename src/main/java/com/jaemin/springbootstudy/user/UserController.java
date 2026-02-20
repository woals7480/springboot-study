package com.jaemin.springbootstudy.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // DTO (간단하게 내부 클래스로)
    public record CreateUserRequest(String email, String name) {}
    public record UpdateUserRequest(String email, String name) {}

    @PostMapping
    public User create(@RequestBody CreateUserRequest req) {
        return userService.create(req.email(), req.name());
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id){
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody UpdateUserRequest req){
        return userService.update(id, req.email(), req.name());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}
