package io.pubby.repositories;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import io.pubby.models.Player;

public interface PlayerRepository extends ReactiveMongoRepository<Player, String> {

}
