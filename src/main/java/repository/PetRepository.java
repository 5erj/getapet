package repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import representation.Pet;

public interface PetRepository extends MongoRepository<Pet, Long>{

}
