/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifnti.l3.jee.controllers;

import ifnti.l3.jee.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ifnti.l3.jee.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author loyal
 */
@Controller
public class UserController {
    
    @Autowired
    UserRepository userRepository;
    
    @GetMapping("/users")
    public String listeUsers(Model model){
        
        //User user1 = new User("eklou","fidele","M","f@đ.com","12345","fidele");
        
        
        
        //userRepository.save(user1);
        
        
        List<User> users = userRepository.findAll();
        
        model.addAttribute("users",users);
        
    return "pages/users";
    }
}
