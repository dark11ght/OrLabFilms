package com.dark1ight.dao;

import com.dark1ight.dto.UsersDto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDtoMapper implements RowMapper<UsersDto> {



    @Override
    public UsersDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        UsersDto usersDto = new UsersDto();
        usersDto.setId(rs.getInt("id"));
        usersDto.setLogin(rs.getString("login"));
        usersDto.setPass(rs.getString("pass"));
        usersDto.setRole(rs.getInt("role"));

        return usersDto;
    }
}
