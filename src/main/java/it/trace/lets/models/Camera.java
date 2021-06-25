package it.trace.lets.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Data
@AllArgsConstructor
public class Camera {

    @Id
    @GeneratedValue
    private Long    id;

    @ManyToOne
    private Scene   scene;

    @NotNull
    @Pattern(regexp = "^-?\\d+,-?\\d+,-?\\d+$", message = "Формат ввода: X,Y,Z")
    private String  center;

    @NotNull
    @Pattern(regexp = "^-?\\d+,-?\\d+,-?\\d+$", message = "Формат ввода: X,Y,Z")
    private String  direction;

    @NotNull
    @Min(value = 45, message = "Угол обзора камеры не меньше 45")
    @Max(value = 180, message = "Угол обзора камеры не больше 180")
    private Integer angle;

    public Camera() {
        this.center = "0,0,0";
        this.direction = "0,0,0";
        this.angle = 45;
    }

    @Override
    public String toString() {
        return  "Точка обзора: [" + center + ']' +
                " Направление: [" + direction + ']' +
                " Угол обзора: [" + angle + ']';
    }

    public String   print() {
        return "c " + this.center + " " + this.direction + " " + this.angle;
    }
}
