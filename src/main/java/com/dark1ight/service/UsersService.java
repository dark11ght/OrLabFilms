package com.dark1ight.service;


import com.dark1ight.dao.UsersDao;
import com.dark1ight.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class UsersService {
    private final UsersDao usersDao;

    @Autowired
    public UsersService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public List<UsersDto> getAll(){
        return usersDao.findAll();
    }

    public UsersDto getUser(int id){
        return usersDao.getUserById(id);
    }

    public void deleteUser(int id){
        usersDao.deleteUserById(id);
    }

    public UsersDto createUser(UsersDto user) {
        return usersDao.createUser(user);
    }

    public  UsersDto updateUser(int id, UsersDto user){
        return  usersDao.updateUser(id, user);
    }

}
