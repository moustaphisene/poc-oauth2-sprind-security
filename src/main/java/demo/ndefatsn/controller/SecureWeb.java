package demo.ndefatsn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecureWeb {

    @GetMapping("/secure")
    public String securePage() {
        return "secure.html";
    }
}
