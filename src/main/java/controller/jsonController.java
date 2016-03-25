package controller;

import entity.Gender;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/3/25.
 */
@Controller
@RequestMapping("/json")
public class jsonController {
    @ResponseBody
    @RequestMapping("/user")
    public User get(){
        User user = new User();
        user.setGender(Gender.MAN);
        user.setName("Bob");
        return user;
    }
}
