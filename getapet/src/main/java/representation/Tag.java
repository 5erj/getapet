package representation;

public class Tag {
	private int id;
	private String name;
	
	/* com.fasterxml.jackson looks for a default constructor
	 * An alternative is to use the @JsonCreator and @JsonProperty annotations
	 * on the other constructor
	 */
	Tag() {}
	
	public Tag(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
