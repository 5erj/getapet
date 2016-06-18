package service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import repository.CounterRepository;

@Service
public class CounterService {
	@Autowired 
	private MongoOperations mongo;

	@Autowired
	private CounterRepository counterRepository;

	public long getNextSequence(String collectionName) {
		// Initialize the counter for this collection
		if (counterRepository.findOne(collectionName) == null) {
			counterRepository.save(new Counter(collectionName, 0));
		}
		
		// Increment and return the next sequence in the counter
		Counter counter = mongo.findAndModify(
				query(where("_id").is(collectionName)), 
				new Update().inc("seq", 1),
				options().returnNew(true),
				Counter.class);

		return counter.getSeq();
	}
}