package ifnti.l3.jee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ifnti.l3.jee.entities.Role;


import ifnti.l3.jee.repositories.RoleRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoleCrudController {

@Autowired
RoleRepository roleRepository;

    @PostMapping("/role/create")
    public List<String> createRole(@RequestBody Role role)  {

        List<String> list = new ArrayList<>();

            roleRepository.save(role);

            list.add("success");

        
        

        return list;
   
        
    }
     @PostMapping("/role/delete/{id}")
        public List<String> deleteRole(@PathVariable String id)  {

        List<String> list = new ArrayList<>();

        try {
            
        roleRepository.deleteById(Long.parseLong(id));
        list.add("success");

        } catch (Exception e) {
            list.add("error");
        }
   
    
        return list;
    }
    
}
