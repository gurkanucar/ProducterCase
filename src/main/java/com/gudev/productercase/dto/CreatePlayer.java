package com.gudev.productercase.dto;

import com.gudev.productercase.model.Position;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlayer {

    @NotNull
    @Min(3)
    @Max(30)
    private String name;

    @NotNull
    @Min(3)
    @Max(30)
    private String surname;

    @NotNull
    private String position;

}
