package com.gudev.productercase.resolver;

import com.gudev.productercase.model.Player;
import com.gudev.productercase.service.PlayerService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerQueryResolver implements GraphQLQueryResolver  {

    private final PlayerService playerService;

    public PlayerQueryResolver(PlayerService playerService) {
        this.playerService = playerService;
    }

    public List<Player> getAllPlayer(){
        return playerService.getAllPlayers();
    }


}
