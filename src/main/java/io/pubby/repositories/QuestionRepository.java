package io.pubby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.pubby.models.Question;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

}
