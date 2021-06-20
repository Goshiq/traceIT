package it.trace.lets.models.figures;

import it.trace.lets.models.Figure;
import it.trace.lets.models.Scene;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
public class Sphere extends Figure{

    private Double  radius;

    public Sphere() {
        this.radius = 0D;
    }
}
