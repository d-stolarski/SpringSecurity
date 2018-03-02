package pl.javastart.springsequrityzadanie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/menu")
    public String showMenu(){
        return "menu";
    }

    @GetMapping("/register")
    public String showRegForm(Model model, User user){
        model.addAttribute("user", new User());
        return "register";
    }


    @PostMapping("/register")
    @ResponseBody
    public String addUser(User user) {
        userRepository.save(user);
        return "Dodano użytkownika do bazy danych!";
    }

    @GetMapping("/")
    public String showMainPage(){
        return "mainPage";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @GetMapping("/username")
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
}
