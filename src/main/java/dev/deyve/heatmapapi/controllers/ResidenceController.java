package dev.deyve.heatmapapi.controllers;

import dev.deyve.heatmapapi.dtos.ResidenceDTO;
import dev.deyve.heatmapapi.models.Residence;
import dev.deyve.heatmapapi.parsers.ResidenceParser;
import dev.deyve.heatmapapi.services.ResidenceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static dev.deyve.heatmapapi.parsers.ResidenceParser.toResidence;
import static dev.deyve.heatmapapi.parsers.ResidenceParser.toResidenceDTO;
import static java.util.stream.Collectors.toList;

@Log4j2
@RestController
@RequestMapping("residences")
public class ResidenceController {

    private final ResidenceService residenceService;

    public ResidenceController(ResidenceService residenceService) {
        this.residenceService = residenceService;
    }

    @GetMapping
    public ResponseEntity<List<ResidenceDTO>> getResidence() {

        List<Residence> residences = residenceService.findResidences();

        List<ResidenceDTO> residenceDTOS = residences.stream()
                .map(ResidenceParser::toResidenceDTO)
                .collect(toList());

        log.info("Residence DTO List: {} ", residenceDTOS);

        return ResponseEntity.ok()
                .header("count", String.format("%d", residences.size()))
                .body(residenceDTOS);
    }

    @PostMapping
    public ResponseEntity<ResidenceDTO> postResidence(@RequestBody ResidenceDTO residenceDTO) {

        Residence residenceSaved = residenceService.saveResidence(toResidence(residenceDTO));

        log.info("ResidenceDTO: {} ", residenceSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(toResidenceDTO(residenceSaved));
    }

    @DeleteMapping("/{externalId}")
    public void deleteResidence(@PathVariable UUID externalId) {

        residenceService.deleteResidence(externalId);
    }
}
