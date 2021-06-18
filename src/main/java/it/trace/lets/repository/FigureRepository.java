package it.trace.lets.repository;

import it.trace.lets.models.Figure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FigureRepository extends JpaRepository<Figure, Long> {
}
