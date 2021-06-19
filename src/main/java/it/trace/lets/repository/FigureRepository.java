package it.trace.lets.repository;

import it.trace.lets.models.Figure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FigureRepository extends JpaRepository<Figure, Long> {
}
