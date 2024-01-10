package ifnti.l3.jee.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ifnti.l3.jee.entities.User;
import ifnti.l3.jee.repositories.UserRepository;

@RestController
public class UserCrudController {

    @Autowired
    UserRepository userRepository;
    @PostMapping("/user/create")
    public List<String> createUser(@RequestBody User user)  {
        List<String> list = new ArrayList<>();
        try {


            userRepository.save(user);

            list.add("success");

        
        } catch (Exception e) {

            list.add("error");

        }

        return list;
   
        
    }

     @PostMapping("/user/delete/{id}")
    public List<String> deleteUser(@PathVariable String id)  {

        List<String> list = new ArrayList<>();

        try {
            
        list.add("success");
        userRepository.deleteById(Long.parseLong(id));

        } catch (Exception e) {
            list.add("error");
        }
   
        


        return list;
    }

    @GetMapping("/user/get/{id}")
    public Optional<User> getUser(@PathVariable String id)  {

        Optional<User> list = userRepository.findById(Long.parseLong(id));

        return list;
    }

    @PostMapping("/user/update")
    public List<String> updateUser(@RequestBody User userUpdated)  {

        List<String> list = new ArrayList<>();

        try {

            Optional<User> optionalUser = userRepository.findById(userUpdated.getId());
            User user = optionalUser.get();
            user.setContact(userUpdated.getContact());
            user.setEmail(userUpdated.getEmail());
            user.setFirstname(userUpdated.getFirstname());
            user.setPassword(userUpdated.getPassword());
            user.setLastname(userUpdated.getLastname());
            user.setUsername(userUpdated.getUsername());
            user.setRoles(userUpdated.getRoles());
            user.setEnabled(userUpdated.getEnabled());

        userRepository.save(user);
        
        list.add("success");

                


        } catch (Exception e) {

            list.add("error");
        }


        return list;
    }
    
}
