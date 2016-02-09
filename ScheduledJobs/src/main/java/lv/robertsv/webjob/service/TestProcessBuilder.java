package lv.robertsv.webjob.service;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class TestProcessBuilder {
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder processBuilder = new ProcessBuilder(
				"D:/Project - Finansportalen/batch jobs/insurance-calculator-batch-peak-week.tasks/insurance-calculator-batch-peak-week.cron.cmd");
		processBuilder.redirectErrorStream(true);
		processBuilder.redirectOutput(Redirect.INHERIT);

		// Add a new environment variable
		// processBuilder.environment().put("message", "Example of process
		// builder");

		// Set the working directory. The batch file will run as if you are in
		// this
		// directory.
		// processBuilder.directory(new File("work"));

		// Start the process and wait for it to finish.
		final Process process = processBuilder.start();
		final int exitStatus = process.waitFor();
		System.out.println(exitStatus);
	}

}
