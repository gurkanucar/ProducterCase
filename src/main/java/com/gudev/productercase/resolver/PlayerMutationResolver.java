package com.gudev.productercase.resolver;

import com.gudev.productercase.dto.CreatePlayer;
import com.gudev.productercase.dto.converter.CreatePlayerConverter;
import com.gudev.productercase.model.Player;
import com.gudev.productercase.service.PlayerService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class PlayerMutationResolver implements GraphQLMutationResolver {

    private final PlayerService playerService;
    private final CreatePlayerConverter converter;


    public PlayerMutationResolver(PlayerService playerService, CreatePlayerConverter converter) {
        this.playerService = playerService;
        this.converter = converter;
    }

    public Player addPlayer(@Valid CreatePlayer createPlayer) {
        Player player = converter.dtoToEntity(createPlayer);
       return playerService.create(player);
    }

    public boolean deletePlayer(Long id) {
        playerService.delete(id);
        return true;
    }

}
