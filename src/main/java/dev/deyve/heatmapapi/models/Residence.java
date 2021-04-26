package dev.deyve.heatmapapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Residence {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    UUID externalId;

    Integer number;

    String zipCode;

    Integer residents;

    Double latitude;

    Double longitude;
}

