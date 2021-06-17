package it.trace.lets.controllers;

import it.trace.lets.models.Figure;
import it.trace.lets.models.Scene;
import it.trace.lets.services.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/scene")
public class SceneController {

    @Autowired
    private SceneService sceneService;

    @GetMapping("/newscene")
    public String   addScene(Model model) {
        return "/scene/newScene";
    }

    @GetMapping("/loadscene")
    public String   loadScene(Model model) {
        sceneService.addScene(new Scene(99L, new Date(), null));
        model.addAttribute("allScenes", sceneService.getAllScenes());
        return "/scene/loadScene";
    }
}
