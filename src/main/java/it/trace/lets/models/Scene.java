package it.trace.lets.models;

import lombok.*;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Scene {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;

    @OneToMany(targetEntity = Figure.class, mappedBy = "scene", fetch = FetchType.EAGER)
    private List<Figure> figures;
}
