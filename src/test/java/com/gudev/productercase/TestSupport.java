package com.gudev.productercase;

import com.gudev.productercase.dto.CreatePlayer;
import com.gudev.productercase.model.Player;
import com.gudev.productercase.model.Position;

public class TestSupport {

    public Player generatePlayer(Long id, String name, String surname, Position position){
        return Player.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .position(position)
                .build();
    }

    public Player generatePlayer(Long id){
        return Player.builder()
                .id(id)
                .build();
    }

    public Player generatePlayer(String name){
        return Player.builder()
                .name(name)
                .build();
    }

    public CreatePlayer generateCreatePlayer( String name, String surname, String position){
        return CreatePlayer.builder()
                .name(name)
                .surname(surname)
                .position(position)
                .build();
    }

    public CreatePlayer generateCreatePlayer( String name){
        return CreatePlayer.builder()
                .name(name)
                .build();
    }

}
