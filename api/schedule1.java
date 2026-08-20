// alterar método main() existente para incluir função periódica

package com.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyApp {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler =
                Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(
                MyApp::runTask,
                0,              // initial delay
                10,             // repeat interval
                TimeUnit.SECONDS
        );

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            scheduler.shutdown();
        }));
    }

    private static void runTask() {
        System.out.println("Task is running");
    }
}
