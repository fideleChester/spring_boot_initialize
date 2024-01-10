/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifnti.l3.jee.controllers;

import ifnti.l3.jee.repositories.RoleRepository;
import ifnti.l3.jee.repositories.UserRepository;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import ifnti.l3.jee.entities.Role;
import ifnti.l3.jee.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.context.Context;


/**
 *
 * @author loyal
 */
@Controller
public class UserController {
    
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    
    @GetMapping("/user/index")
    public String listeUsers(Model model,HttpServletRequest request){

        Context context = new Context();
        
        context.setVariable("request", request);
        
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("roles",roles);

        roleRepository.findById(Long.parseLong("1"));
        
        
        
    return "pages/users";
    }

    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable String id,Model model){
        
        Optional<User> user = userRepository.findById(Long.parseLong(id));  
        model.addAttribute("user",user);

        List<Role> roles = roleRepository.findAll();
        model.addAttribute("roles",roles);
        
    return "pages/user-edit";
    }

@ModelAttribute("servletPath")
  String getRequestServletPath(HttpServletRequest request) {
    return request.getServletPath();
  }
    
    

}
