package com.uds.rest.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.uds.rest.model.Sabor;

public class SaborControllerTest {

	final String baseURL = "http://localhost:9990/uds-pizzaria/sabores";
	final RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testGetSaborListSuccess() throws URISyntaxException {

		URI uri = new URI(baseURL);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		System.out.println(" >> TESTE :: " + result.getBody());

		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("calabresa"));
	}

	@Test
	public void testInsereSaborSuccess() throws URISyntaxException {

		URI uri = new URI(baseURL);

		Sabor novoSabor = new Sabor(null, "Aspargo", 2);

		HttpHeaders headers = new HttpHeaders();

		HttpEntity<Sabor> request = new HttpEntity<>(novoSabor, headers);

		String urlSaborCadastrado = null; 
		
		try {
			ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
			if (response.getStatusCodeValue() == 201) {
				// Obtem a URI do novo sabor criado para que seja removido da base de dados
				int inicio = response.toString().indexOf(baseURL);
				int fim = inicio + baseURL.length() + 2;
				urlSaborCadastrado = response.toString().substring(inicio, fim);
			}
		
			// Assert.fail();
			Assert.assertEquals(201, response.getStatusCodeValue());

			// Removendo Sabor criado
			restTemplate.delete(new URI(urlSaborCadastrado));
		
		
		} catch (HttpClientErrorException ex) {
			Assert.assertEquals(400, ex.getRawStatusCode());
			Assert.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
		}

	}

}
