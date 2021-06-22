package it.trace.lets.controllers;

import it.trace.lets.services.FigureService;
import it.trace.lets.services.SceneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("figure", figureService.findById(figId));
        model.addAttribute("figId", figId);
        return "figure/newSphere";
    }

    @GetMapping("/scene/newscene/{id}/addplane/{figId}")
    public String   addPlane(
            @PathVariable("id") Long sceneId,
            @PathVariable("figId") Long figId,
            Model model) {
        model.addAttribute("figure", figureService.findById(figId));
        model.addAttribute("figId", figId);
        return "figure/newPlane";
    }

    @PostMapping("figure/delete/{id}")
    public String   deleteFigure(@PathVariable("id") Long id) {
        figureService.deleteFigure(id);
        return "redirect:/scene/loadscene";
    }
}
