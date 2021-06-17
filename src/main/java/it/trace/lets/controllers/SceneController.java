package it.trace.lets.controllers;

import it.trace.lets.models.Scene;
import it.trace.lets.services.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/scene")
public class SceneController {

    @Autowired
    private SceneService sceneService;

    @GetMapping("/newscene")
    public String   addScene(Model model) {
        Scene scene = new Scene();
        model.addAttribute("scene", scene);
        return "/scene/newScene";
    }

    @GetMapping("/loadscene")
    public String   loadScene(Model model) {
        model.addAttribute("allScenes", sceneService.getAllScenes());
        return "/scene/loadScene";
    }
}
