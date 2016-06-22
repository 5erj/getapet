package representation;

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
	private Integer id;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Category category;
	
	@NotNull
	private String name;
	
	@NotNull
	@Size(min=1)
	private String[] photoUrls;
	
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
	
	public Pet(Integer id, Category category, String name, String[] photoUrls, 
			Tag[] tags, String status) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.photoUrls = photoUrls;
		this.tags = tags;
		this.status = status;
	}

	public Integer getId() {
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
	public String[] getPhotoUrls() {
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
