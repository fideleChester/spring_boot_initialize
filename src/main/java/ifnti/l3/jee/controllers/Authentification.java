package ifnti.l3.jee.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Authentification {
    
    @RequestMapping("/")
    public String login(){
        return "auth-login";
    }
}
