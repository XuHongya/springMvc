package controller;

import entity.Person;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/22.
 */
@Controller
@RequestMapping("/mvc")
public class mvcController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    /* 访问路径/mvc/person?name=hub&&age=20
    将自动封装参数到对象中
    */
    @RequestMapping("/person")
    public String toPerson(Person person){
        System.out.println(person.getName() + person.getAge());
        return "hello";
    }

    /* /mvc/date?dates=1991-09-26
    将日期直接封装到对象中
    */
    @RequestMapping("/date")
    public String date(Date dates){
        System.out.println(dates);
        return "hello";
    }
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd" ),true));
    }


    @RequestMapping("/show")
    public String showPerson(Map<String,Object> map){
        Person person = new Person();
        person.setAge(15);
        person.setName("Xuhongya");
        map.put("p",person);
        return "show";
    }

    @RequestMapping("redirect")
    public String redirect(){
        return "redirect:hello";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(HttpServletRequest request)throws Exception{
        MultipartHttpServletRequest multiReq = (MultipartHttpServletRequest)request;
        MultipartFile file = multiReq.getFile("file");
        String fileName = file.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        FileOutputStream fos = new FileOutputStream(request.getSession().getServletContext().getRealPath("/")
        +"upload" + sdf.format(new Date()) + fileName.substring(fileName.lastIndexOf('.')));
        fos.write(file.getBytes());
        fos.flush();
        fos.close();

        return "hello";
    }

}
