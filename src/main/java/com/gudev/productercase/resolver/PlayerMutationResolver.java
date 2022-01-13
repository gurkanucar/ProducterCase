package com.gudev.productercase.resolver;

import com.gudev.productercase.dto.CreatePlayer;
import com.gudev.productercase.model.Player;
import com.gudev.productercase.service.PlayerService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
public class PlayerMutationResolver implements GraphQLMutationResolver {

    private final PlayerService playerService;


    public PlayerMutationResolver(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Player addPlayer(@Valid CreatePlayer player) {
       return playerService.create(player);
    }

    public boolean deletePlayer(Long id) {
        playerService.delete(id);
        return true;
    }

}
