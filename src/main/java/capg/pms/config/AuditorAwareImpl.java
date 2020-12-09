/**
 * 
 */
package capg.pms.config;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;

/**
 * @author: AYRUS
 * description: Provides the current user name to the Auditor 
 * created date: 04/11/2020
 * modified: -
 */
public class AuditorAwareImpl implements AuditorAware<String> {

	private static final Logger logger = LoggerFactory.getLogger(AuditorAwareImpl.class);
	//@Override
	public Optional<String> getCurrentAuditor() {
		logger.info("Returning optional string of current auditor.");
		return Optional.of("AYRUS");
	}

}
