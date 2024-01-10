package ifnti.l3.jee.controllers;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import ifnti.l3.jee.entities.User;
import ifnti.l3.jee.repositories.UserRepository;


@Controller
public class Authentification {

    @Autowired
    UserRepository userRepository;
    @GetMapping("/")
    public String login(){
        return "auth-login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam("username") String username, @RequestParam("password") String password,HttpSession session) 
    {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println( userRepository.findByUsernameAndPassword(username, password) );
        if(userRepository.findByUsernameAndPassword(username, password) != null)
        {
            session.setAttribute("userName", username);

            return "redirect:/home";
        }
        return "auth-login";
    }

   
}
