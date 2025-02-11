package app.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldScheduler {

    @Scheduled(fixedDelay = 10000)
    public void sayHelloWorldEvery10Second() {
        System.out.println("Hello World!");
    }
}
