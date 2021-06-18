package it.trace.lets.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Light {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    private String  center;

    private double  radius;

    private int     color;
}
