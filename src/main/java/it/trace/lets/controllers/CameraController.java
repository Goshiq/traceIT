package it.trace.lets.controllers;

import it.trace.lets.models.Camera;
import it.trace.lets.models.Light;
import it.trace.lets.models.Scene;
import it.trace.lets.services.CameraService;
import it.trace.lets.services.LightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class CameraController {

    private final CameraService cameraService;

    @PostMapping("camera/delete/{id}")
    public String   deleteFigure(@PathVariable("id") Long id,
                                 Model model) {
        Camera camera = cameraService.findById(id);
        Scene scene = camera.getScene();
        cameraService.deleteCamera(id);
        return "redirect:/scene/" + scene.getId();
    }
}