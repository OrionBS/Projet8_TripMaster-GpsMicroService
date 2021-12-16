package com.tourguide.GpsMicroService;

import com.tourguide.GpsMicroService.service.impl.GpsServiceImpl;
import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.Location;
import gpsUtil.location.VisitedLocation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@ExtendWith(MockitoExtension.class)
public class GpsServiceUnitTest {

    @InjectMocks
    private GpsServiceImpl gpsService;

    @Mock
    GpsUtil gpsUtil;

    @Test
    public void testGetUserLocation() {
        //GIVEN
        UUID userId = UUID.randomUUID();
        VisitedLocation visitedLocation = new VisitedLocation(userId, new Location(125, 12), new Date());
        Mockito.when(gpsUtil.getUserLocation(userId)).thenReturn(visitedLocation);

        //WHEN
        VisitedLocation visitedLocationReceived = gpsService.getUserLocation(userId);

        //THEN
        Mockito.verify(gpsUtil, Mockito.times(1)).getUserLocation(userId);
        Assertions.assertEquals(visitedLocation, visitedLocationReceived);
    }

    @Test
    public void testGetAttractions() {
        //GIVEN
        List<Attraction> attractions = new ArrayList<>();
        Attraction attraction1 = new Attraction("Eiffel Tower", "Paris", "France", 125, 12);
        Attraction attraction2 = new Attraction("Notre Dame", "Paris", "France", 124, 18);
        attractions.add(attraction1);
        attractions.add(attraction2);
        Mockito.when(gpsUtil.getAttractions()).thenReturn(attractions);

        //WHEN
        List<Attraction> attractionsReceived = gpsService.getAttractions();

        //THEN
        Mockito.verify(gpsUtil, Mockito.times(1)).getAttractions();
        Assertions.assertEquals(attractions, attractionsReceived);
    }
}
