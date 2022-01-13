package com.gudev.productercase.dto;

import com.gudev.productercase.model.Position;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlayer {

    private String name;
    private String surname;
    private String position;

}
