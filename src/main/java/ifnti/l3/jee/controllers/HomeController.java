/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifnti.l3.jee.controllers;

import ifnti.l3.jee.entities.User;
import ifnti.l3.jee.repositories.UserRepository;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author loyal
 */
@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;
    
    @RequestMapping("/home")
    public String homePage(Model model){
        
           List<User> users = userRepository.findAll();
        
        model.addAttribute("users",users);
        
        return "pages/main";
    
    }
    
    
    
     @RequestMapping("/users_")
    public String usersPage(Model model){
        return "pages/users";
    
    }

        @ModelAttribute("servletPath")
  String getRequestServletPath(HttpServletRequest request) {
    return request.getServletPath();
  }
    
}
