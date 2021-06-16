package it.trace.lets.controllers;

import it.trace.lets.repository.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/scene")
public class SceneController {
    @Autowired
    private SceneRepository sceneRepository;

    @GetMapping("/addscene")
    public String   addScene() {
        return "scene/addScene";
    }

    @GetMapping
    public String   openScene() {
        return "scene/openScene";
    }
}
