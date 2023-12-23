/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifnti.l3.jee.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author loyal
 */
@Controller
public class HomeController {
    @Value("${spring.application.name}")
    String appName;
    
    @RequestMapping("/home")
    public String homePage(Model model){
        model.addAttribute("appName",appName);
        return "pages/main";
    
    }
     @RequestMapping("/users_")
    public String usersPage(Model model){
        return "pages/users";
    
    }
    
}
