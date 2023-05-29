package dev.be.modulebatch.jobs;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class SampleBatchConfiguration {

	private final JobRepository jobRepository;
	private final PlatformTransactionManager transactionManager;
	public static final String JOB_NAME = "sampleBatch";

	@Bean
	public Job job() {
		return new JobBuilder(JOB_NAME, jobRepository)
				.start(step())
				.build();
	}

	@Bean
	public Step step() {
		return new StepBuilder(JOB_NAME + "_step", jobRepository)
				.tasklet((contribution, chunkContext) -> {
					log.info("샘플 배치입니다.");
					return RepeatStatus.FINISHED;
				}, transactionManager)
				.build();
	}
}
