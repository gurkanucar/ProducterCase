package com.gudev.productercase.service;

import com.gudev.productercase.dto.CreatePlayer;
import com.gudev.productercase.dto.converter.CreatePlayerConverter;
import com.gudev.productercase.exception.PlayerNotFoundEception;
import com.gudev.productercase.model.Player;
import com.gudev.productercase.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final CreatePlayerConverter converter;


    public PlayerService(PlayerRepository playerRepository, CreatePlayerConverter converter) {
        this.playerRepository = playerRepository;
        this.converter = converter;
    }

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public Player create(CreatePlayer createPlayer){
        Player player = converter.dtoToEntity(createPlayer);
        return playerRepository.save(player);
    }

    public void delete(Long id){
        Player player = playerRepository.findById(id).orElseThrow(
                ()-> new PlayerNotFoundEception("Player not found!")
        );
        playerRepository.delete(player);
    }


}
