package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2016/3/25.
 */
@Controller
@RequestMapping("/test")
public class MVCControl1 {
    @RequestMapping("/param")
    public String testRequestParam(@RequestParam(value="id")Integer id,
                                   @RequestParam(value="name")String name){
        System.out.println("id = " + id +", name = " + name);
        return "hello";
    }
}
