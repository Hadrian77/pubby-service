package io.pubby.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import io.pubby.models.Session;

public interface SessionRepository extends ReactiveMongoRepository<Session, String > {

}
