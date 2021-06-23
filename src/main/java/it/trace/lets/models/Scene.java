package it.trace.lets.models;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Scene {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;

    @OneToMany(targetEntity = Figure.class, mappedBy = "scene", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Figure>    figures = new ArrayList<>();

    @OneToMany(targetEntity = Camera.class, mappedBy = "scene", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Camera>    cameras = new ArrayList<>();

    @OneToMany(targetEntity = Light.class, mappedBy = "scene", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Light>     lights = new ArrayList<>();

    public Scene() {
        this.date = new Date();
    }
}
