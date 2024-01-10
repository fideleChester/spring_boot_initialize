package ifnti.l3.jee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
import ifnti.l3.jee.entities.Role;
import ifnti.l3.jee.repositories.RoleRepository;

@Controller
public class RoleController {

@Autowired
RoleRepository roleRepository;


    //afficher la liste des roles
    @GetMapping("/role/index")
    public String listeUsers(Model model){
        
         List<Role> roles = roleRepository.findAll();


        model.addAttribute("roles",roles);
        
    return "pages/index-role";
    }

    
}
