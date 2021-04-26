package dev.deyve.heatmapapi.repositories;

import dev.deyve.heatmapapi.models.Residence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ResidenceRepository extends JpaRepository<Residence, Long> {

    Optional<Residence> findByExternalId(UUID externalId);
}
