package com.kodilla.testing.forum.statistics;

import java.lang.reflect.Field;

public class Counter {
    private int userCount, postCount, commentCount;
    private double avgPostNumPerUser, avgCommentNumPerUser, avgCommentNumPerPost;
    
    public void calculateAdvStatistics(Statistics statistics){
        userCount = statistics.usersNames().size();
        postCount = statistics.postsCount();
        commentCount = statistics.commentsCount();
        avgPostNumPerUser = calcAvg(postCount, userCount);
        avgCommentNumPerUser = calcAvg(commentCount, userCount);
        avgCommentNumPerPost = calcAvg(commentCount, postCount);
    }
    
    /*
    public void showStatistics(){
        System.out.println(String.format("User count %d,\n post count %d,\ncommentCount %d,\navgPostNumPerUser %.2f,\n" +
                "avgCommentNumPerUser %.2f,\navgCommentNumPerPost %.2f", userCount, postCount, commentCount, avgPostNumPerUser, avgCommentNumPerUser, avgCommentNumPerPost));
    }
    
     */
    
    public void showStatistics(){
        Field[] fields = this.getClass().getDeclaredFields();
        System.out.println("***\nShowing Count fields:");
        for(Field f : fields){
            try{
                System.out.println(f.getName() + " " + f.get(this));
            } catch (Exception e) {
                System.out.println("Error in showStatistics!");
            }
        }
        System.out.println("***");
    }
    
    //to remember!!! double / double 0 doesn't throw ArithmeticException
    private double calcAvg(int what, int perWhat){
        if(perWhat==0){
            return 0;
        } else {
            return (double) what / perWhat;
        }
    }

    public int getUserCount() {
        return userCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public double getAvgPostNumPerUser() {
        return avgPostNumPerUser;
    }

    public double getAvgCommentNumPerUser() {
        return avgCommentNumPerUser;
    }

    public double getAvgCommentNumPerPost() {
        return avgCommentNumPerPost;
    }
}
