package lv.robertsv.webjob.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import lv.robertsv.webjob.domain.Job;

@RestController
@RequestMapping("/job")
public class JobRestController {

	@RequestMapping("/all")
	public List<Job> getJobs() {
		List<Job> jobs = Lists.newArrayList(new Job("Job 1"), new Job("Job 3"));
		return jobs;
	}
}