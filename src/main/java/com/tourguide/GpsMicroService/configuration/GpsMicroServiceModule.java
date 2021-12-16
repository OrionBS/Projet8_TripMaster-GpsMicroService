package com.tourguide.GpsMicroService.configuration;

import gpsUtil.GpsUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class GpsMicroServiceModule {

    @Bean
    public GpsUtil getGpsUtil() {
        Locale.setDefault(Locale.ENGLISH);
        return new GpsUtil();
    }

}
