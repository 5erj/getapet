package representation;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Tag {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer id;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	
	/* com.fasterxml.jackson looks for a default constructor
	 * An alternative is to use the @JsonCreator and @JsonProperty annotations
	 * on the other constructor
	 */
	Tag() {}
	
	public Tag(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
