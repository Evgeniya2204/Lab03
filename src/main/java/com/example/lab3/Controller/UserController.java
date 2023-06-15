package com.example.lab3.Controller;

import com.example.lab3.Dto.CreateUpdateUserDto;
import com.example.lab3.Dto.UserDto;
import com.example.lab3.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable String userId) {
        return userService.getUserDtoById(userId);
    }

    @PostMapping
    public UserDto create(@RequestBody CreateUpdateUserDto createUpdateUserDto) {
        return userService.create(createUpdateUserDto);
    }
}
