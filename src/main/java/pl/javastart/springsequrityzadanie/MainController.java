package pl.javastart.springsequrityzadanie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
