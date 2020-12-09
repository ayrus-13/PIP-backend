/**
 * 
 */
package capg.pms.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author: AYRUS
 * description: Configuration class for JPA Auditing
 * created date: 04/11/2020
 * modified: -
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class PmsConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(PmsConfiguration.class);
	
	/*	
	 *  Author: AYRUS
	 *  Description: Configures the JPA Auditor
	 *  Input: -
	 *  Output: AuditorAware object.
	 *  Created Date: 04/11/2020
	 *  Last Modified: -
	 */
	@Bean
	public AuditorAware<String> auditorAware() {
		logger.info("Configuring JPA Auditor.");
		return new AuditorAwareImpl();
	}

}