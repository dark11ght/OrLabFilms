package com.dark1ight.controllers;



import com.dark1ight.dto.UsersDto;
import com.dark1ight.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class Controller {
        private final UsersService usersService;

        @Autowired
        public Controller(UsersService usersService) {
            this.usersService = usersService;
        }

        @GetMapping
        public List<UsersDto> getEmployee(){
            return usersService.getAll();

        }

        @GetMapping("{id}")
        public UsersDto getOne(@PathVariable int id){
            return usersService.getUser(id);
        }

        @DeleteMapping("{id}")

        public UsersDto delete(@PathVariable int id){
            UsersDto usersDto = usersService.getUser(id);
            usersService.delUser(id);
            return usersDto;
        }

        @PostMapping
        public UsersDto create(@RequestBody UsersDto usersDto){
            usersService.createUser(usersDto);
            return usersDto;
        }



        @PutMapping("{id}")
        public UsersDto update (@PathVariable int id, @RequestBody UsersDto usersDto){
            usersService.updateUser(id, usersDto);
            return usersDto;
        }





}
