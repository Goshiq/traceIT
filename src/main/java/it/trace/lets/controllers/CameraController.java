package it.trace.lets.controllers;

import it.trace.lets.models.Camera;
import it.trace.lets.models.Scene;
import it.trace.lets.services.CameraService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/camera")
public class CameraController {

    private final CameraService cameraService;

    @PostMapping("/delete/{id}")
    public String   deleteFigure(@PathVariable("id") Long id,
                                 Model model) {
        Camera camera = cameraService.findById(id);
        Scene scene = camera.getScene();
        cameraService.deleteCamera(id);
        return "redirect:/scene/" + scene.getId();
    }

    @GetMapping("/{id}")
    public String   editCamera(@PathVariable("id") Long id,
                               Model model) {
        Camera  camera = cameraService.findById(id);
        model.addAttribute("newCamera", camera);
        return "/camera/newCamera";
    }

    @PostMapping("/{id}")
    public String   saveCamera(@PathVariable("id") Long id,
                               @Valid @ModelAttribute("newCamera") Camera camera,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/camera/newCamera";
        Scene scene = cameraService.findById(id).getScene();
        camera.setScene(scene);
        cameraService.update(camera);
        return "redirect:/scene/" + scene.getId();
    }
}