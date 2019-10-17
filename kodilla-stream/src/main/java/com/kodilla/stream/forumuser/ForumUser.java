package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int id;
    private final String name;
    private final char sex;
    private final LocalDate brithDate;
    private final int postCounter;

    public ForumUser(int id, String name, char sex, LocalDate brithDate, int postCounter) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.brithDate = brithDate;
        this.postCounter = postCounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBrithDate() {
        return brithDate;
    }

    public int getPostCounter() {
        return postCounter;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", brithDate=" + brithDate +
                ", postCounter=" + postCounter +
                '}';
    }
}
