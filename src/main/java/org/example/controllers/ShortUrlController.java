package org.example.controllers;

import java.util.HashMap;
import org.example.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortUrlController {

  @Autowired
  private ShortUrlService shortUrlService;

  @PostMapping("create-short-url")
  HashMap<String, Object> createUrlShortener(String longUrl, String manualName) {
    return shortUrlService.createUrlShortener(longUrl, manualName);
  }

  @GetMapping("create-short-url")
  String getUrl(String shortUrl) {
    String hashCode =  getHashCodeOrManualNameFromUrl(shortUrl);
    return shortUrlService.getLongUrl(hashCode);
  }

  private String getHashCodeOrManualNameFromUrl(String shortUrl) {
    // https://x.com/s23fdv
    return shortUrl;
  }
}
