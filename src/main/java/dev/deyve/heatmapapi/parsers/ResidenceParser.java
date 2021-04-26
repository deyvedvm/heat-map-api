package dev.deyve.heatmapapi.parsers;

import dev.deyve.heatmapapi.dtos.ResidenceDTO;
import dev.deyve.heatmapapi.models.Residence;

import java.util.UUID;

public class ResidenceParser {

    public static Residence toResidence(ResidenceDTO residenceDTO) {

        return Residence.builder()
                .externalId(UUID.randomUUID())
                .number(residenceDTO.getNumber())
                .zipCode(residenceDTO.getZipCode())
                .residents(residenceDTO.getResidents())
                .latitude(residenceDTO.getLatitude())
                .longitude(residenceDTO.getLongitude())
                .build();
    }

    public static ResidenceDTO toResidenceDTO(Residence residence) {

        return ResidenceDTO.builder()
                .externalId(residence.getExternalId())
                .number(residence.getNumber())
                .zipCode(residence.getZipCode())
                .residents(residence.getResidents())
                .latitude(residence.getLatitude())
                .longitude(residence.getLongitude())
                .build();
    }
}
