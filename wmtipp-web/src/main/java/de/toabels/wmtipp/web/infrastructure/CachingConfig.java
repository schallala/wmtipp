/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.toabels.wmtipp.web.infrastructure;

import static javax.management.timer.Timer.ONE_DAY;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 *
 * @author abels
 */
@Configuration
@EnableCaching
@EnableScheduling
public class CachingConfig {

  private static final Logger logger = LoggerFactory.getLogger(CachingConfig.class);

  /**
   * Scheduled cache eviting to avoid memory problems
   */
  @Scheduled(fixedRate = ONE_DAY)
  @CacheEvict(value = "lists", allEntries = true)
  public void clearCache() {
    logger.info("Cache cleared.");
  }
    
  
  @Bean
  public CacheManager cacheManager() {
    logger.info("Cache manager intialized.");
    return new ConcurrentMapCacheManager("lists", "entities");
  }
}
