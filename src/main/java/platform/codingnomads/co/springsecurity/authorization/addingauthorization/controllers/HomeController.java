package platform.codingnomads.co.springsecurity.authorization.addingauthorization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.models.MagicBean;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.services.MagicBeanService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    MagicBeanService magicBeanService;

    @GetMapping("/")
    public String homePage() {
        return "authorization/home";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "authorization/admin";
    }

    @GetMapping("/superu")
    public String superUPage() {
        return "authorization/superu";
    }

    @GetMapping("/mas")
    @PreAuthorize("#id != 1")
    public String testMas(int id){
        return "authorization/home";
    }

    @GetMapping("/user-only")
    public String userOnlyPage(){
        return "authorization/user-only";
    }

    @GetMapping("/admin-only")
    public String adminOnlyPage(){
        return "authorization/admin-only";
    }

    @GetMapping("/superu-only")
    public String superuOnlyPage(){
        return "authorization/superu-only";
    }

    @GetMapping("/user-only-msa")
    @RolesAllowed("USER")
    public String userOnlyPageMSA(){
        return "authorization/user-only";
    }

    @GetMapping("/magic-beans")
    public String magicBeansPage(Model model){
        model.addAttribute("beans",magicBeanService.getAllBeans());
        return "authorization/magic-beans";
    }

    @GetMapping("/bean/{colour}")
//    @PreAuthorize("#colour != 'RED'")
    public String beanPage(@PathVariable String colour, Model model){
        MagicBean magicBean = magicBeanService.getBeanByColour(colour);
        if (magicBean != null){
            model.addAttribute("bean",magicBean);
            return "authorization/bean-page";
        } else{
            return "redirect:/";
        }

    }

    /*
        Method Security Annotations

        @RolesAllowed("USER")
        @PreAuthorize("#id != 1")
        @PostAuthorize("returnObject.ownerUsername == authentication.principal.username")
        @PreFilter(value = "filterObject != shutdown", filterTarget = "commands")
        @PostFilter("filterObject.id <= 20")
     */
}