package org.example.repo;

import java.util.HashMap;
import org.example.Model.ShortUrl;
import org.springframework.stereotype.Repository;

@Repository
public class ShortUrlRepository {
  private HashMap<String, ShortUrl> urls;
  private HashMap<String, ShortUrl> longUrls;
  private HashMap<String, ShortUrl> hashCodeUrls;

  public ShortUrlRepository() {
    urls = new HashMap<>();
  }

  public ShortUrl urlAlreadyExisted(String longUrl) {
    for(ShortUrl url: urls.values()) {
      if(longUrl.equals(url.getLongUrl())) {
        return url;
      }
    }
    return null;
  }

  public ShortUrl save(ShortUrl url) {
    urls.put("1", url);
    return url;
  }

  public ShortUrl getActualUrlForGivenShortUrl(String shortUrl) {
    for(ShortUrl url : urls.values()) {
      if(shortUrl.equals(url.getHashCode())) {
        return url;
      }
    }
    return null;
  }
}
