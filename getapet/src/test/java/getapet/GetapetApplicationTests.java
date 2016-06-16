package getapet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import representation.Category;
import representation.Pet;
import representation.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GetapetApplication.class)
@WebAppConfiguration
public class GetapetApplicationTests {
	private MediaType contentType = new MediaType(
			MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf8"));

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {

		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters)
				.stream().filter( hmc -> 
				hmc instanceof MappingJackson2HttpMessageConverter).findAny()
																	.get();

		Assert.assertNotNull("the JSON message converter must not be null",
				this.mappingJackson2HttpMessageConverter);
	}

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void createPetAllRequestParams() throws Exception {
		// Build the request body
		URL[] photoUrls = {new URL("http://test.com")};
		Tag[] tags = {new Tag(0, "bulldog")};
		String requestBody = json(new Pet(0, new Category(0, "dog"), 
				"max", photoUrls, tags, "available"));
		
		// Call the API
		this.mockMvc.perform(post("/pet")
                .contentType(contentType)
                .content(requestBody))
                .andExpect(status().isCreated());
	}
	
	@Test
	public void createPetOnlyRequiredParams() throws Exception {
		// Build the request body
		JSONObject requestBody = new JSONObject();
		requestBody.put("name", "max");
		URL[] photoUrls = {new URL("http://test.com")};
		requestBody.put("photoUrls", new JSONArray(photoUrls));
		
		// Call the API
		this.mockMvc.perform(post("/pet")
                .contentType(contentType)
                .content(requestBody.toString()))
                .andExpect(status().isCreated());
	}

	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = 
				new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(
				o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}

}
;