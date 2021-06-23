package it.trace.lets.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

//    @Min(value = 45, message = "Угол обзора в пределах 45-180")
    @Max(value = 180, message = "Угол обзора в пределах 45-180")
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
