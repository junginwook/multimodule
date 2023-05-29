package dev.be.modulebatch;

import dev.be.modulecommon.config.QuerydslConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TestConfiguration
@Import(QuerydslConfiguration.class)
@EnableAutoConfiguration
@EntityScan("dev.be.modulecommon.domain")
@EnableJpaRepositories("dev.be.modulecommon.repository")
public class TestBatchConfig {

}
