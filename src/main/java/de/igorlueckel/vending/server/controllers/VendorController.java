package de.igorlueckel.vending.server.controllers;

import de.igorlueckel.vending.server.helpers.haversine.HaversineDistance;
import de.igorlueckel.vending.server.helpers.haversine.RectangleBound;
import de.igorlueckel.vending.server.models.Vendor;
import de.igorlueckel.vending.server.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Igor on 13.05.2015.
 */
@RestController
@RequestMapping("/vendor")
public class VendorController {
    @Autowired
    VendorRepository vendorRepository;

    @RequestMapping("/add")
    public Vendor addVendor(@RequestBody Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @RequestMapping("/getNear")
    public List<Vendor> getVendorsNear (@RequestParam double lat1, @RequestParam double lat2, @RequestParam double long1, @RequestParam double long2) {
        return vendorRepository.findByLatitudeBetweenAndLongitudeBetween(Math.min(lat1, lat2), Math.max(lat1, lat2), Math.min(long1, long2), Math.max(long1, long2));
    }

    @RequestMapping("/getNearWithDistance")
    public List<Vendor> getVendorsNearWithDistance (@RequestParam double latitude, @RequestParam double longitude, @RequestParam double distance) {
        RectangleBound rectangleBounds = HaversineDistance.calculateBounds(latitude, longitude, distance);
        return vendorRepository.findByLatitudeBetweenAndLongitudeBetween(Math.min(rectangleBounds.getNorth(), rectangleBounds.getSouth()), Math.max(rectangleBounds.getNorth(), rectangleBounds.getSouth()), Math.min(rectangleBounds.getEast(), rectangleBounds.getWest()), Math.max(rectangleBounds.getEast(), rectangleBounds.getWest()));
    }

    @RequestMapping("/template")
    public Vendor getTemplate() {
        return new Vendor();
    }
}
