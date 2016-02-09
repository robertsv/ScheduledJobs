package lv.robertsv.webjob.service;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("TestJob is executing ...");
	}

}
