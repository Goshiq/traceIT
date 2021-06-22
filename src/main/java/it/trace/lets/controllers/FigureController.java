package it.trace.lets.controllers;

import it.trace.lets.models.*;
import it.trace.lets.services.FigureService;
import it.trace.lets.services.SceneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping("/")
public class FigureController {

    private final SceneService sceneService;

    private final FigureService figureService;

    @GetMapping("/scene/newscene/{id}/addsphere/{figId}")
    public String   addSphere(
            @PathVariable("id") Long sceneId,
            @PathVariable("figId") Long figId,
            Model model) {
        figureService.updateType(figId, FigureType.SPHERE);
        model.addAttribute("figure", figureService.findById(figId));
        model.addAttribute("figId", figId);
        return "figure/newSphere";
    }

    @GetMapping("/scene/newscene/{id}/addplane/{figId}")
    public String   addPlane(
            @PathVariable("id") Long sceneId,
            @PathVariable("figId") Long figId,
            Model model) {
        figureService.updateType(figId, FigureType.PLANE);
        model.addAttribute("figure", figureService.findById(figId));
        model.addAttribute("figId", figId);
        return "figure/newPlane";
    }

    @PostMapping("figure/delete/{id}")
    public String   deleteFigure(@PathVariable("id") Long id,
                                 Model model) {
        Figure  figure = figureService.findById(id);
        Scene scene = figure.getScene();
        figureService.deleteFigure(id);
        return "redirect:/scene/" + scene.getId();
    }

    @PostMapping("figure/{id}")
    public String   saveFigure(@PathVariable("id") Long id,
                               @ModelAttribute("figure") Figure figure,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/index";
        }
        Scene scene = figureService.findById(id).getScene();
        figure.setScene(scene);
        figureService.update(figure);
        return "redirect:/scene/" + scene.getId();
    }
}
