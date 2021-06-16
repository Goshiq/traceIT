package it.trace.lets.controllers;

import it.trace.lets.repository.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scene")
public class SceneController {
    @Autowired
    private SceneRepository sceneRepository;
}
