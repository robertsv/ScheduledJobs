package lv.robertsv.webjob.service;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@DisallowConcurrentExecution
public class ScheduledJob implements Job {
	
	private String path;
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		path = dataMap.getString("PATH");
		
		System.out.println("ScheduledJob with path " + path + " is executing ...");
		
		
		ProcessBuilder processBuilder = new ProcessBuilder(
				"D:/Project - Finansportalen/batch jobs/insurance-calculator-batch-peak-week.tasks/insurance-calculator-batch-peak-week.cron.cmd");
		processBuilder.redirectErrorStream(true);
		processBuilder.redirectOutput(Redirect.INHERIT);

		// Start the process and wait for it to finish.
		try {
			Process process = processBuilder.start();
			final int exitStatus = process.waitFor();
			System.out.println(exitStatus);
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		
		
	}

}
