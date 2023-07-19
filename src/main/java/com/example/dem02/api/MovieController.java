package com.example.dem02.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/movies")
public class MovieController {
	
	private final RestTemplate restTemplate;
    private final String omdbApiKey;
    private final String omdbApiUrl = "http://www.omdbapi.com/";

    public MovieController(RestTemplate restTemplate, @Value("${omdb.api.key}") String omdbApiKey) {
        this.restTemplate = restTemplate;
        this.omdbApiKey = omdbApiKey;
    }

    @GetMapping("/{title}")
    public ResponseEntity<Object> getMovieDetails(@PathVariable String title) {
        String apiUrl = omdbApiUrl + "?apikey=" + omdbApiKey + "&t=" + title;
        ResponseEntity<Object> response = restTemplate.getForEntity(apiUrl, Object.class);
        return response;
    }

}
