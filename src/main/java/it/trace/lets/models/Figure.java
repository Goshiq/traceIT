package it.trace.lets.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.awt.*;

@Entity
@Data
@AllArgsConstructor
public class Figure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    @ManyToOne
    private Scene   scene;

    private FigureType  type;

    private Color color;

    private String  center;

    private String  direction;

    @Min(value = 1, message = "Как ты себе представляешь сферу радиусом меньше 1?")
    private Integer  radius;

    public Figure() {
        this.type = FigureType.NEW;
        this.color = new Color(0,0,0);
        this.center = "0,0,0";
        this.direction = "0,0,0";
        this.radius = 1;
    }
}
