/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.os2mockexam2019;

public class FontysBuilding {

    public static void main(String[] args) {

        //Excercise 3: Threadpool
        
        
        final int NR_OF_STUDENTS = 50;
        ToiletAreaMonitor m = new ToiletAreaMonitor();
        Thread t = null;

// Create and start student threads
        for (int i = 0; i < NR_OF_STUDENTS; i++) {

            t = new Thread(new Student(m));
            t.start();
        }

// Create and start cleaning person thread
        t = new Thread(new CleaningPerson(m));
        t.start();
    }
}
