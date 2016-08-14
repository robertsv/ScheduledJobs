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
import org.springframework.stereotype.Service;

import lv.robertsv.webjob.domain.Job;

@Service
public class ScheduleManager {

	public void addToSchedule(Job job) {

		// TOOD (RV): valid cron "*/2 * * * * ?"
		
		JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class).withIdentity(job.getPath()).build();
		jobDetail.getJobDataMap().put("PATH", job.getPath());
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(job.getPath()).withSchedule(CronScheduleBuilder.cronSchedule(job.getSchedule())).build();
		SchedulerFactory schFactory = new StdSchedulerFactory();
		try {
			Scheduler sch = schFactory.getScheduler();
			sch.start();
			sch.scheduleJob(jobDetail, cronTrigger);
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}

	}

}
