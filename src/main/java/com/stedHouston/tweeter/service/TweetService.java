package com.stedHouston.tweeter.service;

import com.stedHouston.tweeter.model.Tweet;
import com.stedHouston.tweeter.model.User;
import com.stedHouston.tweeter.repository.TweetRepository;
import com.stedHouston.tweeter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TweetService {

    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    @Autowired
    public TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public Tweet saveTweet(Tweet tweet, String username) {
        Optional<User> optionalUser = userRepository.findUserByUsername(username);
        User user = optionalUser.get();
        tweet.setUser(user);
        return tweetRepository.save(tweet);
    }
}
