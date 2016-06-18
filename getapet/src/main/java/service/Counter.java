package service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "counters")
public class Counter {
	@Id
	private String id;
	
	private long seq;
	
	public Counter(String id, long seq) {
		this.id = id;
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public long getSeq() {
		return seq;
	}
}