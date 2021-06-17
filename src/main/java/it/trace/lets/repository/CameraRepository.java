package it.trace.lets.repository;

import it.trace.lets.models.Camera;
import it.trace.lets.models.Figure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CameraRepository extends JpaRepository<Camera, Long> {
    Optional<Camera> findById(Long id);
}
