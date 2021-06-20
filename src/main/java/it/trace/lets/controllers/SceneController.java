package it.trace.lets.controllers;

import it.trace.lets.models.Camera;
import it.trace.lets.models.Figure;
import it.trace.lets.models.Scene;
import it.trace.lets.services.FigureService;
import it.trace.lets.services.SceneService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/scene")
public class SceneController {

    private final SceneService sceneService;

    private final FigureService figureService;

    @GetMapping("/newscene")
    public String   addScene(Model model) {
        Scene   scene = new Scene();
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

    @GetMapping("/newscene/{id}/addfigure")
    public String   addFigure(@PathVariable("id") Long sceneId, Model model) {
//        Figure figure = new Figure();
//        figure.setScene(sceneService.getScene(sceneId));
//        figureService.addFigure(figure);
//        model.addAttribute("newFigureId", figure.getId());
        return "figure/newFigure";
    }
}
