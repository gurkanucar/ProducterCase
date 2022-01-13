package com.gudev.productercase.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Player(String name, String surname, Position position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

    private String name;

    private String surname;

    @Enumerated(EnumType.STRING)
    private Position position;


}
