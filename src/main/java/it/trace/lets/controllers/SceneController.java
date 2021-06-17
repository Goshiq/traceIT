package it.trace.lets.controllers;

import it.trace.lets.repository.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scene")
public class SceneController {

    @Autowired
    private SceneService sceneService;

    @GetMapping("/newscene")
    public String   addScene() {
        return "/scene/newScene";
    }

    @GetMapping("/loadscene")
    public String   loadScene(Model model) {
        model.addAttribute("allScenes", sceneService.getAllScenes());
        return "/scene/loadScene";
    }
}
