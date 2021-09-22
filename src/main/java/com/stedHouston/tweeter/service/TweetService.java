package com.stedHouston.tweeter.service;

import com.stedHouston.tweeter.model.Tweet;
import com.stedHouston.tweeter.model.User;
import com.stedHouston.tweeter.repository.TweetRepository;
import com.stedHouston.tweeter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TweetService {

    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    @Autowired
    public TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public void saveTweet(Tweet tweet, String handle) {
        Optional<User> optionalUser = userRepository.findUserByHandle(handle);
        User user = optionalUser.get();
        user.getTweets().add(tweet);
    }
}
