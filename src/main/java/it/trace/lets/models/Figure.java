package it.trace.lets.models;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.awt.*;

import static it.trace.lets.utils.ColorConverter.getRGB;

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

    @NotNull
    @Pattern(regexp = "^-?\\d+,-?\\d+,-?\\d+$", message = "Формат ввода: X,Y,Z")
    private String  center;

    @NotNull
    @Pattern(regexp = "^-?\\d+,-?\\d+,-?\\d+$", message = "Формат ввода: X,Y,Z")
    private String  direction;

    @NotNull
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
                    " Цвет: [" + color + "]" +
                    " Координаты точки на плоскости: [" + center + "]" +
                    " Направление нормали: [" + direction + "]";
        }
        else if (this.type == FigureType.SPHERE) {
            answer = type.getName() +
                    ": " +
                    " Цвет: [" + color + "]" +
                    " Координаты центра: [" + center + "]" +
                    " Радиус: [" + radius + "]";
        }
        return answer;
    }

    public String print() {
        String ans;
        if (this.type == FigureType.SPHERE) {
            ans = "sp " + this.center + " " + this.radius + " " + getRGB(this.color);
        }
        else if (this.type == FigureType.PLANE) {
            ans = "pl " + this.direction + " " + getRGB(this.color);
        }
        else {
            ans = "type of the figure is not set";
        }
        return ans;
    }
}
