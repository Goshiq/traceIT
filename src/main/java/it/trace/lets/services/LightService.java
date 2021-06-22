package it.trace.lets.services;

import it.trace.lets.models.Light;
import it.trace.lets.repository.LightRepository;
import org.springframework.stereotype.Service;

@Service
public class LightService {
    private final LightRepository   lightRepository;

    public LightService(LightRepository lightRepository) {
        this.lightRepository = lightRepository;
    }

    public void addLight(Light light) {
        lightRepository.save(light);
    }

    public Light    findById(Long id) {
        return lightRepository.getById(id);
    }

    public void deleteLight(Long id) {
        lightRepository.deleteById(id);
    }

    public void update(Light light) {
        lightRepository.save(light);
    }
}
