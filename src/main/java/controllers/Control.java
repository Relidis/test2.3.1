package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class Control {

    @GetMapping("/hello")
    public String hello(){
        return "users/hello";
    }
}
