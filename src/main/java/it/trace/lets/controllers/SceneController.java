package it.trace.lets.controllers;

import it.trace.lets.models.Scene;
import it.trace.lets.services.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/scene")
public class SceneController {

    @Autowired
    private SceneService sceneService;

    @GetMapping("/newscene")
    public String   addScene(Model model) {
        Scene   scene = new Scene();
        scene.setDate(new Date());
        sceneService.addScene(scene);
        model.addAttribute("newScene", scene);
        model.addAttribute("newSceneId", scene.getId());
        return "scene/newScene";
    }

    @GetMapping("/loadscene")
    public String   loadScene(Model model) {
        model.addAttribute("allScenes", sceneService.getAllScenes());
        return "scene/loadScene";
    }

    @GetMapping("/{id}")
    public String   showScene(@PathVariable("id") Long id, Model model) {
        model.addAttribute("scene", sceneService.getScene(id));
        return "scene/showScene";
    }

    @PostMapping("/delete/{id}")
    public String   deleteScene(@PathVariable("id") Long id) {
        sceneService.deleteScene(id);
        return "redirect:/scene/loadscene";
    }

    @PostMapping("/create")
    public String   creteScene(@RequestBody Scene scene) {
        sceneService.addScene(scene);
        return "redirect:/scene/loadscene";
    }

    @PostMapping("/newscene/{id}/addfigure")
    public String   addFigure(@PathVariable("newSceneId") Long sceneId) {

    }
}
