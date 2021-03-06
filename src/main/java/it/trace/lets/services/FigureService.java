package it.trace.lets.services;

import it.trace.lets.models.Figure;
import it.trace.lets.models.FigureType;
import it.trace.lets.models.Scene;
import it.trace.lets.repository.FigureRepository;
import org.springframework.stereotype.Service;

@Service
public class FigureService {
    private final FigureRepository  figureRepository;

    public FigureService(FigureRepository figureRepository) {
        this.figureRepository = figureRepository;
    }

    public Figure   findById(Long id) {
        return figureRepository.findById(id).orElse(null);
    }

    public void     addFigure(Figure figure) {
        figureRepository.save(figure);
    }

    public void     deleteFigure(Long id) {
        figureRepository.deleteById(id);
    }

    public void updateType(Long figId, FigureType type) {
        Figure figure = figureRepository.findById(figId).orElse(null);
        if (figure == null) {
            return;
        }
        figure.setType(type);
        figureRepository.save(figure);
    }

    public void update(Figure figure) {
        figureRepository.save(figure);
    }
}
