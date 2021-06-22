package it.trace.lets.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@AllArgsConstructor
public class Camera {

    @Id
    @GeneratedValue
    private Long    id;

    @ManyToOne
    private Scene   scene;

    @Valid
    private String  center;

    private String  direction;

//    @Max(value = 180, message = "Угол обзора в пределах 45-180")
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
