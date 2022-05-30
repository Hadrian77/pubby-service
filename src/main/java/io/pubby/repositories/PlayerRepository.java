package io.pubby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.pubby.models.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
