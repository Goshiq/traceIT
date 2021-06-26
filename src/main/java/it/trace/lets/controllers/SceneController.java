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
        if (scene == null) {
            return "error";
        }
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

    @GetMapping("/{id}/addfigure")
    public String   addFigure(@PathVariable("id") Long sceneId, Model model) {
        Figure figure = new Figure();
        Scene scene = sceneService.getScene(sceneId);
        if (scene == null) {
            return "error";
        }
        figure.setScene(scene);
        figureService.addFigure(figure);
        model.addAttribute("newFigureId", figure.getId());
        return "figure/newFigure";
    }

    @GetMapping("/{id}/addcamera")
    public String   addCamera(@PathVariable("id") Long sceneId, Model model) {
        Camera camera = new Camera();
        Scene scene = sceneService.getScene(sceneId);
        if (scene == null) {
            return "error";
        }
        camera.setScene(scene);
        cameraService.addCamera(camera);
        model.addAttribute("newCamera", camera);
        return "camera/newCamera";
    }

    @GetMapping("/{id}/addlight")
    public String   addLight(@PathVariable("id") Long sceneId, Model model) {
        Light   light = new Light();
        Scene scene = sceneService.getScene(sceneId);
        if (scene == null) {
            return "error";
        }
        light.setScene(scene);
        lightService.addLight(light);
        model.addAttribute("newLight", light);
        return "light/newLight";
    }

    @GetMapping("/{id}/print")
    public String   printScene(@PathVariable("id") Long sceneId, Model model) {
        Scene scene = sceneService.getScene(sceneId);
        if (scene == null) {
            return "error";
        }
        model.addAttribute("scene", scene);
        return "scene/printScene";
    }
}
