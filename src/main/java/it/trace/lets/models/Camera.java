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

    @Pattern(regexp = "^\\d+,\\d+,\\d+$", message = "Формат ввода: X,Y,Z")
    private String  center;

    @Pattern(regexp = "^\\d+,\\d+,\\d+$", message = "Формат ввода: X,Y,Z")
    private String  direction;

//    @Pattern(regexp = "^\\b([1-9]|[1-9][0-9]|1[0-7][0-9]|180)\\b$", message = "Угол лежит в пределах 45-180")
//    @NotNull
//    @Min(45)
    @Max(180)
    private Integer angle;

    public Camera() {
        this.center = "0,0,0";
        this.direction = "0,0,0";
        this.angle = 0;
    }

    @Override
    public String toString() {
        return  "Точка обзора: [" + center + ']' +
                " Направление: [" + direction + ']' +
                " Угол обзора: [" + angle + ']';
    }
}
