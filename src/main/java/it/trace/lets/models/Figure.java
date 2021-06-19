package it.trace.lets.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
public class Figure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    private FigureType  type;

    private Integer color;

    private String  center;

    private String  direction;

    private Double  radius;

    @ManyToOne
    private Scene   scene;

    public Figure() {
        this.type = FigureType.SPHERE;
        this.color = 0;
        this.center = "0,0,0";
        this.direction = "0,0,0";
        this.radius = 0D;
    }
}
