package com.kodilla.patterns.strategy.social;

public class User {
    public static final String ACTIVITY = " shared post on: ";
    final private String name;
    protected SocialPublisher socialPublisher;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public String sharePost() {
        String message = name + ACTIVITY + socialPublisher.share();
        System.out.println(message);
        return message;
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
