package io.pubby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.pubby.models.Session;

public interface SessionRepository extends JpaRepository<Session, Integer > {

}
