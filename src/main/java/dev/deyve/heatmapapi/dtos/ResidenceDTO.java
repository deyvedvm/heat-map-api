package dev.deyve.heatmapapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResidenceDTO {

    UUID externalId;

    Integer number;

    String zipCode;

    Integer residents;

    Double latitude;

    Double longitude;
}
