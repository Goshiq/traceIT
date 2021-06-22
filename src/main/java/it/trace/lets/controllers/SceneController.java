package it.trace.lets.controllers;

import it.trace.lets.models.Camera;
import it.trace.lets.models.Figure;
import it.trace.lets.models.Light;
import it.trace.lets.models.Scene;
import it.trace.lets.services.CameraService;
import it.trace.lets.services.FigureService;
import it.trace.lets.services.LightService;
import it.trace.lets.services.SceneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/scene")
public class SceneController {

    private final SceneService sceneService;

    private final FigureService figureService;

    private final CameraService cameraService;

    private final LightService lightService;


    @GetMapping("/newscene")
    public String   addScene(Model model) {
        Scene   scene = new Scene();
        sceneService.addScene(scene);
        model.addAttribute("newSceneId", scene.getId());
        return "scene/createScene";
    }

    @GetMapping("/loadscene")
    public String   loadScene(Model model) {
        model.addAttribute("allScenes", sceneService.getAllScenes());
        return "scene/loadScene";
    }

    @GetMapping("/{id}")
    public String   showScene(@PathVariable("id") Long id, Model model) {
        Scene   scene = sceneService.getScene(id);
        sceneService.clearFigures(scene);
        model.addAttribute("newScene", scene);
        model.addAttribute("newSceneId", scene.getId());

        model.addAttribute("figures", scene.getFigures());
        model.addAttribute("cameras", scene.getCameras());
        model.addAttribute("lights", scene.getLights());
        return "scene/newScene";
    }

    @PostMapping("/delete/{id}")
    public String   deleteScene(@PathVariable("id") Long id) {
        sceneService.deleteScene(id);
        return "redirect:/scene/loadscene";
    }

    @GetMapping("/newscene/{id}/addfigure")
    public String   addFigure(@PathVariable("id") Long sceneId, Model model) {
        Figure figure = new Figure();
        figure.setScene(sceneService.getScene(sceneId));
        figureService.addFigure(figure);
        model.addAttribute("newFigureId", figure.getId());
        return "figure/newFigure";
    }

    @GetMapping("/newscene/{id}/addcamera")
    public String   addCamera(@PathVariable("id") Long sceneId, Model model) {
        Camera camera = new Camera();
        camera.setScene(sceneService.getScene(sceneId));
        cameraService.addCamera(camera);
        model.addAttribute("newCamera", camera);
        return "camera/newCamera";
    }

    @GetMapping("/newscene/{id}/addlight")
    public String   addLight(@PathVariable("id") Long sceneId, Model model) {
        Light   light = new Light();
        light.setScene(sceneService.getScene(sceneId));
        lightService.addLight(light);
        model.addAttribute("newLight", light);
        return "light/newLight";
    }
}
