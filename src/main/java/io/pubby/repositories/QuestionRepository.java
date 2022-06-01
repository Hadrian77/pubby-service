package io.pubby.repositories;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import io.pubby.models.Question;

public interface QuestionRepository extends ReactiveMongoRepository<Question,String> {

}
