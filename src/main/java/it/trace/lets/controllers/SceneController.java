package it.trace.lets.controllers;

import it.trace.lets.models.Figure;
import it.trace.lets.models.Scene;
import it.trace.lets.repository.SceneRepository;
import it.trace.lets.services.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/scene")
public class SceneController {

    @Autowired
    private SceneService sceneService;

    @GetMapping("/newscene")
    public String   addScene(Model model) {
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
    public String deleteScene(@PathVariable("id") Long id) {
        sceneService.deleteScene(id);
        return "redirect:/scene/loadscene";
    }
}
