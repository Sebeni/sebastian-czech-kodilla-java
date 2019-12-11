package com.kodilla.patterns.strategy.social.publishers;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class SnapchatPublisher implements SocialPublisher {
    public static final String NAME = "Snapchat";
    
    
    @Override
    public String share() {
        return NAME;
    }
}
