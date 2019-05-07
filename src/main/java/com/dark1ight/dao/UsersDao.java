package com.dark1ight.dao;

import com.dark1ight.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UsersDao {



    private final UserDtoMapper userDtoMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public UsersDao(UserDtoMapper userDtoMapper, NamedParameterJdbcTemplate jdbcTemplate) {
        this.userDtoMapper = userDtoMapper;
        this.jdbcTemplate = jdbcTemplate;
    }


    public UsersDto getUserById(int id) {

        String sql = "Select * from users where id =:id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.queryForObject(sql, params, userDtoMapper);
    }

    public void deleteUserById(int id) {
        KeyHolder holder = new GeneratedKeyHolder();
        String sql = "DELETE from users where id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        jdbcTemplate.update(sql, params, holder, new String[]{"id"});
    }


    public List<UsersDto> findAll() {
        return jdbcTemplate.query("Select * from users", userDtoMapper);
    }


    public UsersDto createUser(UsersDto usersDto) {
        KeyHolder holder = new GeneratedKeyHolder();
        String sql = "INSERT INTO users (login, pass, role) VALUES (:login,:pass,:role)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("login", usersDto.getLogin());
        params.addValue("pass", usersDto.getPass());
        params.addValue("role", usersDto.getRole());


        jdbcTemplate.update(sql, params, holder, new String[]{"id"});
        usersDto.setId(holder.getKey().intValue());
        return usersDto;
    }





    public UsersDto updateUser(int id, UsersDto usersDto){
        KeyHolder holder = new GeneratedKeyHolder();
        String sql ="UPDATE  users SET login=:login, pass=:pass, role=:role WHERE id=:id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        params.addValue("login", usersDto.getLogin());
        params.addValue("pass", usersDto.getPass());
        params.addValue("role", usersDto.getRole());


        jdbcTemplate.update(sql,params,holder, new String[] { "id" });
        return usersDto;
    }
}
