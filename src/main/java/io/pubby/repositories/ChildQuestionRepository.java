package io.pubby.repositories;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import io.pubby.models.ChildQuestion;


public interface ChildQuestionRepository extends ReactiveMongoRepository<ChildQuestion,String> {

}
