package it.trace.lets.models;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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

    private String color;

    private String  center;

    private String  direction;

    @Min(value = 1, message = "Как ты себе представляешь сферу радиусом меньше 1?")
    private Integer  radius;

    public Figure() {
        this.type = FigureType.NEW;
        this.color = new Color(0,0,0).toString();
        this.center = "0,0,0";
        this.direction = "0,0,0";
        this.radius = 1;
    }

    @Override
    public String toString() {
        String  answer;

        answer = "Refresh the page ;)";

        if (this.type == FigureType.PLANE) {
            answer = type.getName() +
                    ": " +
//                    "Цвет (R;G;B): [" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "]" +
                    " Цвет (R;G;B): [" + color + "]" +
                    " Координаты точки на плоскости: [" + center + "]" +
                    " Направление нормали: [" + direction + "]";
        }
        else if (this.type == FigureType.SPHERE) {
            answer = type.getName() +
                    ": " +
//                    "Цвет (R;G;B): [" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "]" +
                    " Цвет (R;G;B): [" + color + "]" +
                    " Координаты центра: [" + center + "]" +
                    " Радиус: [" + radius + "]";
        }
        return answer;
    }
}
