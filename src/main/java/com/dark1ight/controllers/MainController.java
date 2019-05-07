package com.dark1ight.controllers;


import com.dark1ight.entities.Users;
import com.dark1ight.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    //регулярка для проверки валидности login и pass
    private static final String LOGIN_PASS_PATTERN = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(value = {"/", "index"})
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value = {"sign_page"})
    public String getSignPage(){
        return "sign_page";
    }

    @RequestMapping(value = "userfilm")
    public ModelAndView getUserFilms(@RequestParam String login, @RequestParam String pass){
        ModelAndView mav = new ModelAndView();
        String validResult = authValid(login, pass);

        if(validResult == null){
            mav.setViewName("userfilm");

        } else {
            mav.addObject("message", validResult);
            mav.setViewName("informer");
        }
        return mav;
    }

    //проверка на корректность ввода данных (login, pass)
    private String authValid(String login, String pass){

        /*if(!login.matches(LOGIN_PASS_PATTERN)){
            return "Не корректный логин!";
        }*/
        /*if(!pass.matches(LOGIN_PASS_PATTERN)){
            return "Не корректный пароль!";
        }*/


        Users user = usersRepository.findByLogin(login);


        if(user == null){
            return "Такого пользователя не уществует";
        }
        if(!pass.equals(user.getPass())){
            return "Не верный пароль";
        }
        return  null;
    }

}
