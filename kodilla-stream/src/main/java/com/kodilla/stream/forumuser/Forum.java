package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> forumUserList;
    
    public Forum(){
        forumUserList = new ArrayList<>();
        LocalDate birthDate = LocalDate.of(1990, 01, 01);
        for(int i = 0; i < 10; i += 2){
            forumUserList.add(new ForumUser(100 + i, "MaleUser #" + i, 'M', birthDate.minusYears(i), i));
            forumUserList.add(new ForumUser(100 + i + 1, "FemaleUser #" + i + 1, 'F', birthDate.plusYears(i), i));
        }
        forumUserList.add(new ForumUser(99, "MaleUser #" + 99, 'M', LocalDate.of(2010, 01, 01), 100));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUserList);
    }
}
