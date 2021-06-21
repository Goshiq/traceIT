package it.trace.lets.controllers;

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

    @GetMapping("{id}/addsphere/{figId}")
    public String   addSphere(
            @PathVariable("id") Long sceneId,
            @PathVariable("figId") Long figId,
            Model model) {
//        Figure figure = new Figure();
//        figureService.addFigure(figure);
        model.addAttribute("figure", figureService.findById(figId));
        model.addAttribute("figId", figId);
        return "figure/newSphere";
    }

    @GetMapping("{id}/addplane/{figId}")
    public String   addPlane(
            @PathVariable("id") Long sceneId,
            @PathVariable("figId") Long figId,
            Model model) {
//        Figure figure = new Figure();
//        figureService.addFigure(figure);
//        model.addAttribute("figId", figure.getId());
        model.addAttribute("figure", figureService.findById(figId));
        model.addAttribute("figId", figId);
        return "figure/newPlane";
    }
}
