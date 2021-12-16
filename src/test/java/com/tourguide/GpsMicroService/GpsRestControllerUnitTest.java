package com.tourguide.GpsMicroService;

import com.tourguide.GpsMicroService.restController.GpsRestController;
import com.tourguide.GpsMicroService.service.impl.GpsServiceImpl;
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
public class GpsRestControllerUnitTest {

    @InjectMocks
    GpsRestController gpsRestController;

    @Mock
    GpsServiceImpl gpsService;

    @Test
    public void testGetUserLocation() {
        //GIVEN
        UUID userId = UUID.randomUUID();
        VisitedLocation visitedLocation = new VisitedLocation(userId, new Location(125, 12), new Date());
        Mockito.when(gpsService.getUserLocation(userId)).thenReturn(visitedLocation);

        //WHEN
        VisitedLocation visitedLocationReceived = gpsRestController.getUserLocation(userId);

        //THEN
        Mockito.verify(gpsService,Mockito.times(1)).getUserLocation(userId);
        Assertions.assertEquals(visitedLocation,visitedLocationReceived);
    }
    @Test
    public void testGetAttractions() {
        //GIVEN
        List<Attraction> attractions = new ArrayList<>();
        Attraction attraction1 = new Attraction("Eiffel Tower", "Paris", "France", 125, 12);
        Attraction attraction2 = new Attraction("Notre Dame", "Paris", "France", 124, 18);
        attractions.add(attraction1);
        attractions.add(attraction2);
        Mockito.when(gpsService.getAttractions()).thenReturn(attractions);

        //WHEN
        List<Attraction> attractionListReceived = gpsRestController.getAttractions();

        //THEN
        Mockito.verify(gpsService,Mockito.times(1)).getAttractions();
        Assertions.assertEquals(attractions,attractionListReceived);
    }

}
