package it.trace.lets.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
public class Camera {

    @Id
    @GeneratedValue
    private Long    id;

    @ManyToOne
    private Scene   scene;

    public Camera() {

    }
}
