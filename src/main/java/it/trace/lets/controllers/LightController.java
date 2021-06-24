package it.trace.lets.controllers;

import it.trace.lets.models.Light;
import it.trace.lets.models.Scene;
import it.trace.lets.services.LightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/light")
public class LightController {

    private final LightService lightService;

    @PostMapping("/delete/{id}")
    public String   deleteLight(@PathVariable("id") Long id,
                                Model model) {
        Light light = lightService.findById(id);
        Scene scene = light.getScene();
        lightService.deleteLight(id);
        return "redirect:/scene/" + scene.getId();
    }

    @GetMapping("/{id}")
    public String   editLight(@PathVariable("id") Long id,
                              Model model) {
        Light   light = lightService.findById(id);
        model.addAttribute("newLight", light);
        return "/light/newLight";
    }

    @PostMapping("/{id}")
    public String   saveLight(@PathVariable("id") Long id,
                              @ModelAttribute("newLight") @Valid Light light,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/light/newLight";
        Scene scene = lightService.findById(id).getScene();
        light.setScene(scene);
        lightService.update(light);
        return "redirect:/scene/" + scene.getId();
    }
}
