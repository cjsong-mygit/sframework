package murong.controller;

import murong.example.Example2;
import murong.support.dao.JdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by murong on 2017/5/15.
 */
@Controller
public class HaHaController {

    @Autowired
    private JdbcDao jdbcDao;


    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String test(){
        System.out.println("hello world!");
        return "home";
    }

    @RequestMapping(value = "/spittle",method = RequestMethod.GET)
    public String spittle(@RequestParam String username, Map model){
        Example2 example2 = new Example2(username,null);
        model.put("spittle",example2);
        return "spittles";
    }

    @RequestMapping(value = "/registerForm",method = RequestMethod.GET)
    public String registerForm(){
        return "registerForm";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(Example2 example2){
        return "redirect:/"+example2.getId();
    }


    @RequestMapping(value = "/{username}")
    public String userInfo(@PathVariable("username") String username,Model model){
        return "redirect:/spittle?username="+username;
    }


    @RequestMapping(value = "/hahahaha")
    public void testdao(){
        System.out.println("hahhahah");
        System.out.println(jdbcDao.findOne().getName());
    }
}
