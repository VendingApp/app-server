package de.igorlueckel.vending.server.controllers;

import de.igorlueckel.vending.server.repositories.VendorTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Igor on 13.05.2015.
 */
@RestController
@RequestMapping("/vendorType")
public class VendorTypeController {
    @Autowired
    VendorTypeRepository vendorTypeRepository;
}
