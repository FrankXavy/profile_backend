package com.fxf.profile.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TwitterController.TWITTER_BASE_API)
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin
public class TwitterController {

  public static final String TWITTER_BASE_API = "/tweets";

  @Autowired
  private Environment env;

  private String consumerKey;
  private String consumerSecret;
  private String accessToken;
  private String accessTokenSecret;
  private Twitter twitter;

  @PostConstruct
  public void init() {
    consumerKey = env.getProperty("twitter.app.id");
    consumerSecret = env.getProperty("twitter.app.secret");
    accessToken = env.getProperty("twitter.access.token");
    accessTokenSecret = env.getProperty("twitter.access.token.secret");
    twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
  }


  /*@RequestMapping(value = "{hashtag}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<Tweet> getTweets(@PathVariable final String hashtag) {
    return twitter.searchOperations().search(hashtag, 20).getTweets();
  }*/

  @GetMapping("timeline/{username}")
  public ResponseEntity<List<Tweet>> getTimeline(@PathVariable(value = "username") String username) {
    try {
      return new ResponseEntity<>(twitter.timelineOperations().getUserTimeline(username, 5), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
