package com.example.dem02.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {
	
	 private final RestTemplate restTemplate;
	    private final String omdbApiKey;
	    private final String omdbApiUrl = "http://www.omdbapi.com/";

	    public MovieService(RestTemplate restTemplate, @Value("${omdb.api.key}") String omdbApiKey) {
	        this.restTemplate = restTemplate;
	        this.omdbApiKey = omdbApiKey;
	    }

	    public ResponseEntity<Object> getMovieDetails(String title) {
	        String apiUrl = omdbApiUrl + "?apikey=" + omdbApiKey + "&t=" + title;
	        ResponseEntity<Object> response = restTemplate.getForEntity(apiUrl, Object.class);
	        return response;
	    }

}
