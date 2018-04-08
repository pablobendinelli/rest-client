package ar.com.meli.restClient;

import org.json.JSONException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {

	Client client = Client.create();
	String postUrl = "http://meli-test-mutant.appspot.com//mutant";

	public void postRequest(String inputData) throws JSONException {
		WebResource webResource = client.resource(postUrl);
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, inputData);

		String result = response.getEntity(String.class);
		System.out.println("Response from the Server: status :" + response.getStatus());
		System.out.println(result);
	}

	public static void main(String[] args) throws JSONException {
		RestClient restClient = new RestClient();
		System.out.println("Prueba: Mutante");
		restClient.postRequest("{\"dna\":[\"AAAAGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}");

		System.out.println("Prueba: NO Mutante");
		restClient = new RestClient();
		restClient.postRequest("{\"dna\":[\"ATGCGA\",\"CAGTGC\",\"TTATTT\",\"AGACGG\",\"GCGTCA\",\"TCACTG\"]}");

	}
}
