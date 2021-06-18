package it.trace.lets.controllers;

import it.trace.lets.models.Scene;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class IndexController {

    @GetMapping
    public String   index(Model model) {
        return "index";
    }
}
