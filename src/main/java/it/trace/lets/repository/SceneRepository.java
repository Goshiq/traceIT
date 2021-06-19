package it.trace.lets.repository;

import it.trace.lets.models.Figure;
import it.trace.lets.models.Scene;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SceneRepository extends JpaRepository<Scene, Long> {
}
