package it.trace.lets.repository;

import it.trace.lets.models.Scene;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SceneRepository extends JpaRepository<Scene, Long> {
    Scene   findByDate(String date);
}
