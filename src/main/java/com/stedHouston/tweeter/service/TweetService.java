package com.stedHouston.tweeter.service;

import com.stedHouston.tweeter.model.Tweet;
import com.stedHouston.tweeter.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetService {

    private final TweetRepository tweetRepository;

    @Autowired
    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

}
