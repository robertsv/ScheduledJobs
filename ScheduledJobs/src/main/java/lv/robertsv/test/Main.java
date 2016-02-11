package lv.robertsv.test;

import java.util.List;
import java.util.stream.Collectors;

import com.speedment.Manager;
import com.speedment.Speedment;

import lv.robertsv.speedment.test.TestApplication;
import lv.robertsv.speedment.test.webjobs.public_.scheduled_job.ScheduledJob;

public class Main {
    public static void main(String... params) {
        Speedment speedment = new TestApplication().withPassword("postgres").build();
        Manager<ScheduledJob> users = speedment.managerOf(ScheduledJob.class);
        List<ScheduledJob> XXX = users.stream().collect(Collectors.toList());
        System.out.println(XXX);
        
    }
}