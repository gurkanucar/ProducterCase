package com.gudev.productercase.dto.converter;

import com.gudev.productercase.dto.CreatePlayer;
import com.gudev.productercase.model.Player;
import com.gudev.productercase.model.Position;
import org.springframework.stereotype.Component;

@Component
public class CreatePlayerConverter {

    public Player dtoToEntity(CreatePlayer dto){
        return Player.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .position(Position.valueOf(dto.getPosition()))
                .build();
    }

}
