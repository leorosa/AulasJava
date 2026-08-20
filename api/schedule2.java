package com.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyApp {
    public static void main(String[] args) {
        PeriodicTask task = new PeriodicTask();

        ScheduledExecutorService scheduler =
                Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(
                task::run,
                0,
                10,
                TimeUnit.SECONDS
        );
    }
}

/////

public class PeriodicTask {
    public void run() {
        System.out.println("Task is running");
    }
}

