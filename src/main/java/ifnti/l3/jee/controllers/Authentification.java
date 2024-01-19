package ifnti.l3.jee.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ifnti.l3.jee.entities.User;
import ifnti.l3.jee.repositories.UserRepository;

@Controller
public class Authentification {

    @Autowired
    UserRepository userRepository;

    /*
     * @GetMapping("/")
     * public String login() {
     * return "auth-login";
     * }
     */

    @GetMapping("/login")
    public String loginSubmit(String error, String logout, Model model) {

        if (error != null) {
            model.addAttribute("error", "le nom  d'utilisateur ou mot de passe invalide.");

        }
        if (logout != null) {
            model.addAttribute("message", "Vous avez été déconnecté avec succès!");

        }
        return "auth-login";
    }

}
