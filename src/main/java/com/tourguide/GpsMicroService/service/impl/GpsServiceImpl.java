package com.tourguide.GpsMicroService.service.impl;

import com.tourguide.GpsMicroService.service.GpsService;
import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GpsServiceImpl implements GpsService {

    private Logger logger = LoggerFactory.getLogger(GpsServiceImpl.class);
    private final GpsUtil gpsUtil;

    public GpsServiceImpl(GpsUtil gpsUtil) {
        this.gpsUtil = gpsUtil;
    }

    @Override
    public VisitedLocation getUserLocation(UUID userId) {
        logger.info("Call " + userId);
        return gpsUtil.getUserLocation(userId);

    }

    @Override
    public List<Attraction> getAttractions() {
        logger.info("Call");
        return gpsUtil.getAttractions();
    }
}
