package it.trace.lets.services;

import it.trace.lets.models.Figure;
import it.trace.lets.models.Scene;
import it.trace.lets.repository.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneService {

    private final SceneRepository sceneRepository;

    public SceneService(SceneRepository sceneRepository) {
        this.sceneRepository = sceneRepository;
    }

    public List<Scene> getAllScenes() {
        return sceneRepository.findAll();
    }

    public Scene    addScene(Scene scene) {
        return sceneRepository.save(scene);
    }

    public Scene    getScene(Long id) {
        return sceneRepository.getById(id);
    }

    public void     deleteScene(Long id) {
        sceneRepository.deleteById(id);
    }

    public List<Figure> getFigures(Long id) {
        Scene   scene = sceneRepository.getById(id);
        return scene.getFigures();
    }
}
