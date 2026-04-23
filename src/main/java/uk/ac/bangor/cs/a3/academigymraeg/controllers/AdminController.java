package uk.ac.bangor.cs.a3.academigymraeg.controllers;

import uk.ac.bangor.cs.a3.academigymraeg.models.User;
import uk.ac.bangor.cs.a3.academigymraeg.models.Role;
import uk.ac.bangor.cs.a3.academigymraeg.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin/user-list";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", Role.values());
        return "admin/user-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("id") Long id, @RequestParam("newPassword") String newPassword) {
        User user = userRepository.findById(id).orElseThrow();
        user.setPassword(newPassword);
        userRepository.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return "redirect:/admin/users";
    }
}