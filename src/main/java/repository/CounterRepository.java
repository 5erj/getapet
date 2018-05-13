package repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import service.Counter;

public interface CounterRepository extends MongoRepository<Counter, String>{

}