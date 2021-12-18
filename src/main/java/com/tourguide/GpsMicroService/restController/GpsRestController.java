package com.tourguide.GpsMicroService.restController;

import com.tourguide.GpsMicroService.service.GpsService;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class GpsRestController {

    private final GpsService gpsService;

    public GpsRestController(GpsService gpsService) {
        this.gpsService = gpsService;
    }

    /**
     * Transmet la dernière localisation de l'utilisateur.
     * @param userId l'id de l'utilisateur.
     * @return la dernière VisitedLocation de l'utilisateur.
     */
    @GetMapping(path = "/getUserLocation")
    public VisitedLocation getUserLocation(@RequestParam UUID userId) {
        return gpsService.getUserLocation(userId);
    }

    /**
     * Transmet la liste des attractions connues.
     * @return la liste avec toutes les Attractions dedans.
     */
    @GetMapping(path = "/getAttractions")
    public List<Attraction> getAttractions() {
        return gpsService.getAttractions();
    }

}
