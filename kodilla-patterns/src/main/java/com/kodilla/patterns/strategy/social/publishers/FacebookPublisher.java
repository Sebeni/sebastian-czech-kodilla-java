package com.kodilla.patterns.strategy.social.publishers;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class FacebookPublisher implements SocialPublisher {
    public static final String NAME = "Facebook";
    
    @Override
    public String share() {
        return NAME;
    }
}
