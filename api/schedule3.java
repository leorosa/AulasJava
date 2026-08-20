import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.*;

public class MyApp {
    private static final ZoneId ZONE =
            ZoneId.systemDefault();

    public static void main(String[] args) {
        ScheduledExecutorService scheduler =
                Executors.newSingleThreadScheduledExecutor();

        scheduleDailyTask(scheduler);

        Runtime.getRuntime().addShutdownHook(
                new Thread(scheduler::shutdown)
        );
    }

    private static void scheduleDailyTask(
            ScheduledExecutorService scheduler) {

        ZonedDateTime now = ZonedDateTime.now(ZONE);

        ZonedDateTime todayAtSix = now
                .withHour(6)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        if (now.isAfter(todayAtSix)) {
            // 6:00 AM has passed, so run immediately.
            runTask();

            // Schedule the next run for tomorrow at 6:00 AM.
            ZonedDateTime tomorrowAtSix = todayAtSix.plusDays(1);
            scheduleAt(scheduler, tomorrowAtSix);
        } else {
            // 6:00 AM has not happened yet, so wait until today at 6:00 AM.
            scheduleAt(scheduler, todayAtSix);
        }
    }

    private static void scheduleAt(
            ScheduledExecutorService scheduler,
            ZonedDateTime targetTime) {

        ZonedDateTime now = ZonedDateTime.now(ZONE);

        long delayInSeconds = Duration
                .between(now, targetTime)
                .getSeconds();

        scheduler.schedule(() -> {
            runTask();

            // Schedule the following day's 6:00 AM run.
            scheduleAt(scheduler, targetTime.plusDays(1));

        }, delayInSeconds, TimeUnit.SECONDS);
    }

    private static void runTask() {
        System.out.println("Daily task is running");
    }
}

/////

// Replace ZoneId.systemDefault() with a specific timezone if needed:

private static final ZoneId ZONE =
        ZoneId.of("America/New_York");

