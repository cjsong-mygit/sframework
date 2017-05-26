package murong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by murong on 2017/4/29.
 */
@Controller
public class HomeController {

    //处理/example1?count=23这样的请求
    @RequestMapping(value = "/example1" ,method = RequestMethod.GET)
    public String home(@RequestParam(value = "count",defaultValue = "20") int count,Model model ){
        model.addAttribute("arg1",count);
        return "example1";
    }

    //处理/example2/23这样的rest请求
    @RequestMapping(value = "/example2/{count}",method = RequestMethod.GET)
    public String example2(@PathVariable("count") int count,Model model){
        model.addAttribute("arg1",count);
        return "example2";
    }

    @RequestMapping(value = "/example3",method = RequestMethod.POST)
    public String example3(){
        return "redirect:/example3/haha";//重定向防止重复提交
        //return "forward:/example2";//定向到/example2
    }

    //返回的视图名是当前的，即example4
    @RequestMapping(value = "/example4",method = RequestMethod.GET)
    public List<String> example4(){
        return new ArrayList<String>();
    }
}
