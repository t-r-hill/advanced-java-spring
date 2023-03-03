package platform.codingnomads.co.springtest.usingmockmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Bobbert");
        return "greeting";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String greet() {
        return "Hello Back";
    }

    @PostMapping("/")
    public String postGreeting(@RequestParam String name, Model model){
        model.addAttribute("name", "Robert");
        return "greeting";
    }

    @GetMapping("/goodbye")
    @ResponseBody
    public String bidFarewell(){
        return "Adieu";
    }
}
