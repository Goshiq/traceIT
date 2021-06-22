package it.trace.lets.controllers;

import it.trace.lets.models.Figure;
import it.trace.lets.models.Light;
import it.trace.lets.models.Scene;
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
public class LightController {

    private final LightService lightService;

    @PostMapping("light/delete/{id}")
    public String   deleteFigure(@PathVariable("id") Long id,
                                 Model model) {
        Light light = lightService.findById(id);
        Scene scene = light.getScene();
        lightService.deleteLight(id);
        return "redirect:/scene/" + scene.getId();
    }
}
