package com.tourguide.GpsMicroService.service;

import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

import java.util.List;
import java.util.UUID;

public interface GpsService {

    public VisitedLocation getUserLocation(UUID userId);

    public List<Attraction> getAttractions();
}
