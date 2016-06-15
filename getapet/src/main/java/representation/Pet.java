package representation;

import javax.validation.constraints.Pattern;

public class Pet {
	// TODO: Deal with optional parameters
	private int id;
	private Category category;
	private String name;
	private String[] photoUrls;
	private Tag[] tags;
	
	@Pattern.List({
	    @Pattern(regexp="available|pending|sold"),
	})
	private String status;

	/* com.fasterxml.jackson looks for a default constructor
	 * An alternative is to use the @JsonCreator and @JsonProperty annotations
	 * on the other constructor
	 */
	Pet() {}
	
	public Pet(int id, Category category, String name, String[] photoUrls, 
			Tag[] tags, String status) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.photoUrls = photoUrls;
		this.tags = tags;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public Category getCategory() {
		return category;
	}
	public String getName() {
		return name;
	}
	public String[] getPhotoUrls() {
		return photoUrls;
	}
	public Tag[] getTags() {
		return tags;
	}
	public String getStatus() {
		return status;
	}

}
