package com.higgsup.thread.Synchronization;/*
  By Chi Can Em  05-03-2018
 */

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        Student student1 = new Student();
        student.setName("student ");
        student1.setName("student1 ");

        student.start();
        student1.start();



    }
}
