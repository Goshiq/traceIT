package it.trace.lets.controllers;

import it.trace.lets.models.Figure;
import it.trace.lets.models.figures.Plane;
import it.trace.lets.models.figures.Sphere;
import it.trace.lets.services.FigureService;
import it.trace.lets.services.SceneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/scene/newscene")
public class FigureController {

    private final SceneService sceneService;

    private final FigureService figureService;

    @GetMapping("{id}/addsphere")
    public String   addSphere(
            @PathVariable("id") Long sceneId,
            Model model) {
        Figure sphere = new Sphere();
        model.addAttribute("figId", sphere.getId());
        return "figure/newSphere";
    }

    @GetMapping("{id}/addplane")
    public String   addPlane(
            @PathVariable("id") Long sceneId,
            Model model) {
        Figure plane = new Plane();
        model.addAttribute("figId", plane.getId());
        return "figure/newPlane";
    }
}
