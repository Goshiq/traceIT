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
public class Plane extends Figure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    @ManyToOne
    private Scene scene;

    private Integer color;

    private String  center;

    public Plane() {
        this.color = 0;
        this.center = "0,0,0";
    }
}
