package lv.robertsv.webjob.service;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class TestQuartz {

	public static void main(String[] args) throws SchedulerException, InterruptedException {
		JobDetail job = JobBuilder.newJob(TestJob.class).withIdentity("testJob").build();

		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("crontrigger", "crontriggergroup1")
				.withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ?")).build();
		
		SchedulerFactory schFactory = new StdSchedulerFactory();
		Scheduler sch = schFactory.getScheduler();
		sch.start();
		
		sch.scheduleJob(job, cronTrigger);
		
		Thread.sleep(10 * 1000);
		
		sch.deleteJob(job.getKey());
		
		sch.shutdown(true);
		
	}

}
