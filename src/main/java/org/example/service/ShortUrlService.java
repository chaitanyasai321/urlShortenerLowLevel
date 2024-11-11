package org.example.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import org.example.Model.ShortUrl;
import org.example.repo.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlService {

  @Autowired
  private ShortUrlRepository shortUrlRepository;

  public HashMap<String, Object> createUrlShortener(String longUrl, String manualName) {
    HashMap<String,Object> response = new HashMap<>();
    ShortUrl url = shortUrlRepository.urlAlreadyExisted(longUrl);
    if(Objects.nonNull(url)) {
      response.put("found", true);
      response.put("short", url.getHashCode());
      return response;
    }
    url = new ShortUrl();
    url.setLongUrl(longUrl);
    url.setManualName(manualName);
    url.setHashCode(createHashCodeUnique(longUrl));
    url.setExpiryDate(new Date()); // today's Date + 15 days
    ShortUrl savedurl = shortUrlRepository.save(url);

    response.put("success", Boolean.TRUE);
    response.put("hashCode", savedurl.getHashCode());
    return response;
  }

  private String createHashCodeUnique(String longUrl) {
    return "ACVDSRW";
  }

  public String getLongUrl(String shortUrl) {
    ShortUrl url = shortUrlRepository.getActualUrlForGivenShortUrl(shortUrl);
    if(Objects.isNull(url)) {
      throw new RuntimeException("URL NOT FOUND");
    }
    return url.getLongUrl();
  }
}
