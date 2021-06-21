package it.trace.lets.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.awt.*;

@Entity
@Data
@AllArgsConstructor
public class Light {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    @ManyToOne
    private Scene   scene;

    private String  center;

    private Color color;

    private Double  intensity;

    public Light() {
        this.center = "0,0,0";
        this.color = new Color(0,0,0);
        this.intensity = 0D;
    }
}
