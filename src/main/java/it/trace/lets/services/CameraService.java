package it.trace.lets.services;

import it.trace.lets.models.Camera;
import it.trace.lets.repository.CameraRepository;
import org.springframework.stereotype.Service;

@Service
public class CameraService {
    private final CameraRepository  cameraRepository;

    public CameraService(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    public Camera   findById(Long id) {
        return cameraRepository.findById(id).orElse(null);
    }

    public void addCamera(Camera camera) {
        cameraRepository.save(camera);
    }

    public void deleteCamera(Long id) {
        cameraRepository.deleteById(id);
    }

    public void update(Camera camera) {
        cameraRepository.save(camera);
    }
}
