package dev.deyve.heatmapapi.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@ToString
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

    LocalDateTime exclusion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Residence residence = (Residence) o;
        return id != null && Objects.equals(id, residence.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

