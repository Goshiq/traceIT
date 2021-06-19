package it.trace.lets.services;

import it.trace.lets.models.Figure;
import it.trace.lets.repository.FigureRepository;
import org.springframework.stereotype.Service;

@Service
public class FigureService {
    private final FigureRepository  figureRepository;

    public FigureService(FigureRepository figureRepository) {
        this.figureRepository = figureRepository;
    }

    public Figure   findById(Long id) {
        return figureRepository.getById(id);
    }

    public void     addFigure(Figure figure) {
        figureRepository.save(figure);
    }
}
