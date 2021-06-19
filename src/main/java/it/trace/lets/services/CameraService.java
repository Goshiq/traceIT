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
        return cameraRepository.getById(id);
    }
}
