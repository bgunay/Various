package pl.jvsystem.http.jerseyClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 15.12.13 18:43
 */
public class UserInfoClient
{
	public static final String BASE_URI = "http://localhost:8080/rest/";
	public static final String PATH_NAME = "UserInfoService/name/";


	public static void main(String[] args)
	{
		Client client = Client.create();
		WebResource webResource = client.resource(BASE_URI);
		WebResource nameResource = webResource.path(PATH_NAME + "Przemek");
		ClientResponse response = getClientResponse(nameResource);
		System.out.println("Client Response \n" + response.toString());
		System.out.println("Response \n" + response.getEntity(String.class));
	}

	private static ClientResponse getClientResponse(WebResource resource)
	{
		return resource.accept(MediaType.TEXT_XML).get(ClientResponse.class);
	}

	private static String getResponse(WebResource resource)
	{
		return resource.accept(MediaType.TEXT_XML).get(String.class);
	}


}
