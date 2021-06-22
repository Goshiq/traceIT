package it.trace.lets.services;

import it.trace.lets.models.*;
import it.trace.lets.repository.FigureRepository;
import it.trace.lets.repository.SceneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SceneService {

    private final SceneRepository sceneRepository;

    private final FigureRepository figureRepository;

    public List<Scene> getAllScenes() {
        return sceneRepository.findAll();
    }

    public void     addScene(Scene scene) {
        sceneRepository.save(scene);
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

    public List<Camera> getCameras(Long id) {
        Scene   scene = sceneRepository.getById(id);
        return scene.getCameras();
    }

    public List<Light>  getLights(Long id) {
        Scene   scene = sceneRepository.getById(id);
        return scene.getLights();
    }

    public void clearFigures (Scene scene) {
        List<Figure>    figures = scene.getFigures();
        for (Figure fig:figures
             ) {
            if (fig.getType() == FigureType.NEW) {
                figureRepository.deleteById(fig.getId());
            }
        }
    }
}
