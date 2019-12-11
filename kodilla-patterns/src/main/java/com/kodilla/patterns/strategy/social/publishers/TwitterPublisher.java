package com.kodilla.patterns.strategy.social.publishers;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class TwitterPublisher implements SocialPublisher {
    public static final String NAME = "Twitter";
    
    @Override
    public String share() {
        return NAME;
    }
}
