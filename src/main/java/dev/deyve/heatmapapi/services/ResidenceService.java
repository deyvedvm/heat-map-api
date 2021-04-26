package dev.deyve.heatmapapi.services;

import dev.deyve.heatmapapi.models.Residence;
import dev.deyve.heatmapapi.repositories.ResidenceRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@Service
public class ResidenceService {

    private final ResidenceRepository residenceRepository;

    public ResidenceService(ResidenceRepository residenceRepository) {
        this.residenceRepository = residenceRepository;
    }

    public Residence saveResidence(Residence residence) {

        Residence residenceSaved = residenceRepository.save(residence);

        log.debug("Residence: {} ", residenceSaved);

        return residenceSaved;
    }

    public List<Residence> findResidences() {

        List<Residence> residences = residenceRepository.findAll();

        log.debug("Residences: {} ", residences);

        return residences;
    }

    public void deleteResidence(UUID externalId) {

        Optional<Residence> optionalResidence = residenceRepository.findByExternalId(externalId);

        optionalResidence.ifPresent(residence -> residenceRepository.deleteById(residence.getId()));
    }
}
