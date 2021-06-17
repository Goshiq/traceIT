package it.trace.lets.controllers;

import it.trace.lets.models.Scene;
import it.trace.lets.repository.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneService {

    @Autowired
    private SceneRepository sceneRepository;

    public List<Scene> getAllScenes() {
        return sceneRepository.findAll();
    }
}
