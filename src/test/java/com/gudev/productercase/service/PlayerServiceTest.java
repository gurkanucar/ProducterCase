package com.gudev.productercase.service;

import com.gudev.productercase.TestSupport;
import com.gudev.productercase.dto.CreatePlayer;
import com.gudev.productercase.dto.converter.CreatePlayerConverter;
import com.gudev.productercase.exception.PlayerCountReachedToMaxEception;
import com.gudev.productercase.exception.PlayerNotFoundEception;
import com.gudev.productercase.model.Player;
import com.gudev.productercase.model.Position;
import com.gudev.productercase.repository.PlayerRepository;
import graphql.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest(properties = {"maxPlayerCount = 5"})
class PlayerServiceTest extends TestSupport {


    private PlayerService playerService;
    private CreatePlayerConverter converter;
    private PlayerRepository playerRepository;


    @BeforeEach
    void setup() {
        playerRepository = Mockito.mock(PlayerRepository.class);
        converter = Mockito.mock(CreatePlayerConverter.class);
        playerService = new PlayerService(playerRepository, converter);
    }


    @Test
    @DisplayName("Get all players from database")
    public void testGetAllPlayers() {
        playerService.getAllPlayers();
        Mockito.verify(playerRepository, Mockito.times(1)).findAll();
    }

    @Test
    @DisplayName("create player when team person count less then max count")
    public void createPlayer_whenMaxPersonCountNotReachedYet() {

        final var expected = generatePlayer("ahmet");

        Mockito.when(playerRepository.findAll())
                .thenReturn(Collections.emptyList());

        Mockito.when(playerRepository.save(expected))
                .thenReturn(expected);


        final var createPlayer = generateCreatePlayer("ahmet");

        final var actual = playerService.create(createPlayer);

        Assertions.assertEquals(expected, actual);
        Mockito.verify(playerRepository).save(expected);


    }

    @Test
    @DisplayName("create player when person count has reached to max person count throw exception")
    public void testCreatePlayer_whenMaxPersonCountReached() {
        final var createPlayer = generateCreatePlayer("ahmet");

        Throwable exception = Assertions.assertThrows(PlayerCountReachedToMaxEception.class,
                () -> playerService.create(createPlayer));
        Assertions.assertEquals(PlayerCountReachedToMaxEception.class, exception.getClass());

    }

    @Test
    @DisplayName("delete player by id from database when id exists")
    public void testDeletePlayer_whenIdExists() {

        final var player = generatePlayer(Long.MAX_VALUE);

        Mockito.when(playerRepository.findById(player.getId())).thenReturn(Optional.of(player));

        playerService.delete(player.getId());
        Mockito.verify(playerRepository, Mockito.times(1)).delete(player);

    }

    @Test
    @DisplayName("delete player by id from database when id doesn't exist")
    public void testDeletePlayer_whenIdDoesntExist() {

        Throwable exception = Assertions.assertThrows(PlayerNotFoundEception.class,
                () -> playerService.delete(Long.MAX_VALUE));
        Assertions.assertEquals(PlayerNotFoundEception.class, exception.getClass());

    }


}