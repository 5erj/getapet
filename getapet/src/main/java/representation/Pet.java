package representation;

import java.net.URL;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Pet {
	private int id;
	private Category category;
	@NotNull
	private String name;
	@NotNull
	@Size(min=1)
	private URL[] photoUrls;
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
	
	public Pet(int id, Category category, String name, URL[] photoUrls, 
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
	public URL[] getPhotoUrls() {
		return photoUrls;
	}
	public Tag[] getTags() {
		return tags;
	}
	public String getStatus() {
		return status;
	}

}
