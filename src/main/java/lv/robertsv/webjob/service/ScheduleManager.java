package lv.robertsv.webjob.service;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import lv.robertsv.webjob.domain.Job;

@Service
public class ScheduleManager {

	@Autowired
	private Scheduler sch;

	@Autowired
	private SimpMessagingTemplate template;

	public void addToSchedule(Job job) {

		// TODO (RV): valid cron "*/2 * * * * ?"
		//job.setSchedule(job.getSchedule() + " ?");
		job.setSchedule("*/5 * * * * ?");

		JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class).withIdentity(job.getPath()).build();
		jobDetail.getJobDataMap().put(ScheduledJob.JobParameters.JOB_ID.name(), job.getId());
		jobDetail.getJobDataMap().put(ScheduledJob.JobParameters.MSG_SRV.name(), template);
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(job.getId().toString())
				.withSchedule(CronScheduleBuilder.cronSchedule(job.getSchedule())).build();
		try {
			sch.start();
			sch.scheduleJob(jobDetail, cronTrigger);
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}

	}

}
