package com.tourguide.GpsMicroService.service;

import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

import java.util.List;
import java.util.UUID;

public interface GpsService {

    /**
     * Récupère la dernière localisation de l'utilisateur.
     * @param userId l'id de l'utilisateur.
     * @return la dernière VisitedLocation de l'utilisateur.
     */
    public VisitedLocation getUserLocation(UUID userId);

    /**
     * Récupère la liste des attractions connues.
     * @return la liste avec toutes les Attractions dedans.
     */
    public List<Attraction> getAttractions();
}
