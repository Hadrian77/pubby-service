package io.pubby.repositories;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import io.pubby.models.AnswerRecord;

public interface AnswerRecordRepository extends ReactiveMongoRepository<AnswerRecord,String> {

}
