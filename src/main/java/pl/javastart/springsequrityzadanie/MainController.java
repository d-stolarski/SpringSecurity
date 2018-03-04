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

    @Autowired
    private UserRoleRepository userRoleRepository;

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/menu")
    public String showMenu(){
        return "menu";
    }

    @GetMapping("/register")
    public String showRegForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("userRole", new UserRole());
        return "register";
    }


    @PostMapping("/register")
    public String addUser(User user, UserRole userRole) {
        userRepository.save(user);
        userRoleRepository.save(userRole);
        return "redirect:/";
    }

    @GetMapping("/")
    public String showMainPage(){
        return "mainPage";
    }

    @GetMapping("/edit")
    public String editUserForm(Model model, Principal principal) {
        User user = userRepository.findUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit")
    public String saveEditUser(User user, Principal principal) {
        User newUser = userRepository.findUserByUsername(principal.getName());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEnabled(user.isEnabled());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setTelNumber(user.getTelNumber());

        userRepository.save(newUser);
        return "redirect:/menu";
    }

    @GetMapping("/username")
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
}
