package com.gudev.productercase.repository;

import com.gudev.productercase.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("select p.position from Player p")
    List<String> getBusyPositions();

}
