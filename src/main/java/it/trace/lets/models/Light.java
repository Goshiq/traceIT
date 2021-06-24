package it.trace.lets.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

    @NotNull
    @Pattern(regexp = "^-?\\d+,-?\\d+,-?\\d+$", message = "Формат ввода: X,Y,Z")
    private String  center;

    private String color;

    private Double  intensity;

    public Light() {
        this.center = "0,0,0";
        this.color = new Color(0,0,0).toString();
        this.intensity = 0D;
    }

    @Override
    public String toString() {
        return  "Точка расположения: [" + center + ']' +
                " Цвет: [" + color + "]" +
                " Интенсивность освещения: [" + intensity/100 + ']';
    }
}
