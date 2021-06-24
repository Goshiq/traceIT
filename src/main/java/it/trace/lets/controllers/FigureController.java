package it.trace.lets.controllers;

import it.trace.lets.models.*;
import it.trace.lets.services.FigureService;
import it.trace.lets.services.SceneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@AllArgsConstructor
@RequestMapping("/")
public class FigureController {

    private final SceneService sceneService;

    private final FigureService figureService;

    @PostMapping("/addsphere/{figId}")
    public String   addSphere(
            @PathVariable("figId") Long figId,
            Model model) {
        figureService.updateType(figId, FigureType.SPHERE);
        model.addAttribute("figure", figureService.findById(figId));
        model.addAttribute("figId", figId);
        return "figure/newSphere";
//        return "redirect:" + figId;
    }

    @PostMapping("/addplane/{figId}")
    public String   addPlane(
            @PathVariable("figId") Long figId,
            Model model) {
        figureService.updateType(figId, FigureType.PLANE);
        Figure figure = figureService.findById(figId);
        model.addAttribute("figure", figure);
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

    @GetMapping("figure/{id}")
    public String   editFigure(@PathVariable("id") Long id,
                               Model model) {
        Figure  figure = figureService.findById(id);
        model.addAttribute("figure", figure);
        if (figure.getType() == FigureType.PLANE) {
            return "/figure/newPlane";
        }
        else if (figure.getType() == FigureType.SPHERE) {
            return "/figure/newSphere";
        }
        return "/index";
    }

    @PostMapping("figure/{id}")
    public String   saveFigure(@PathVariable("id") Long id,
                               @ModelAttribute("figure") @Valid Figure figure,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            if (figure.getType() == FigureType.SPHERE) {
                return "figure/newSphere";
            }
            else if (figure.getType() == FigureType.PLANE) {
                return "figure/newPlane";
            }
            else {
                figureService.deleteFigure(id);
                return "/index";
            }
        }
        Scene scene = figureService.findById(id).getScene();
        figure.setScene(scene);
        figureService.update(figure);
        return "redirect:/scene/" + scene.getId();
    }
}
