package it.trace.lets.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Figure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    private FigureType  type;

    private int     color;

    @ManyToOne
    private Scene   scene;
}
