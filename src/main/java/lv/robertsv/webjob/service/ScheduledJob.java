package lv.robertsv.webjob.service;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import lv.robertsv.webjob.domain.JobStatus;

@DisallowConcurrentExecution
@Component
public class ScheduledJob implements Job {

	public static enum JobParameters {
		JOB_ID, JOB_PATH, MSG_SRV;
	}

	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		long jobId = dataMap.getLong(JobParameters.JOB_ID.name());
		SimpMessagingTemplate messagingTemplate = (SimpMessagingTemplate) dataMap.get(JobParameters.MSG_SRV.name());

		// TODO (RV): add impl
		ProcessBuilder processBuilder = new ProcessBuilder(
				"D:/Project - Finansportalen/batch jobs/insurance-calculator-batch-peak-week.tasks/insurance-calculator-batch-peak-week.cron.cmd");
		processBuilder.redirectErrorStream(true);
		processBuilder.redirectOutput(Redirect.INHERIT);

		try {
			messagingTemplate.convertAndSend("/jobstatus", new JobStatus(jobId, JobStatus.ExecutionStatus.RUNNING));
			Process process = processBuilder.start();
			// TODO (RV): what to do with exit status
			int exitStatus = process.waitFor();
			messagingTemplate.convertAndSend("/jobstatus", new JobStatus(jobId, JobStatus.ExecutionStatus.SUCCESS));
		} catch (IOException | InterruptedException e) {
			messagingTemplate.convertAndSend("/jobstatus", new JobStatus(jobId, JobStatus.ExecutionStatus.FAILED));
			throw new RuntimeException(e);
		}

	}

}
