package com.computeralchemist.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @Author
 * Karol Meksuła
 * 11-05-2018
 * */

@Configuration
@EnableCaching
public class CacheAppConfig {

    @Bean
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheCacheManager().getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheCacheManager() {
        EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
        cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
        cmfb.setShared(true);
        return cmfb;
    }

}
