package com.kodilla.patterns2.forum;

public class ForumUser implements Observer {
    private final String userName;
    private int updateCount;

    public ForumUser(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(ForumTopic forumTopic) {
        System.out.println(String.format("%s : New messages in topic %s \n (total:  %d messages)", 
                userName, forumTopic.getName(), forumTopic.getMessages().size()));
        updateCount++;
    }

    public String getUserName() {
        return userName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
