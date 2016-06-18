package representation;

import java.net.URL;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection = "pets")
public class Pet {
	@Id
	@JsonIgnore
	private long resourceId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private int id;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Category category;
	
	@NotNull
	private String name;
	
	@NotNull
	@Size(min=1)
	private URL[] photoUrls;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Tag[] tags;
	
	@Pattern.List({
	    @Pattern(regexp="available|pending|sold"),
	})
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
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
	
	public long getResourceId() {
		return resourceId;
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
	
	public void setResourceId(long id) {
		this.resourceId = id;
	}

}
