package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {

    public static void main(String[] args) {
        User user = null;

        MessageSender ms = new MessageSender();
        try {
            ms.sendMessageTo(user, "Hello");
        } catch (MessageNotSentException e){
            System.out.println("Message is not send. Why?");
            System.out.println(e);
        }
        System.out.println("other logic");
    }
    
}
