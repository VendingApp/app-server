package de.igorlueckel.vending.server.controllers;

import de.igorlueckel.vending.server.models.Brand;
import de.igorlueckel.vending.server.models.VendorType;
import de.igorlueckel.vending.server.repositories.VendorTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Igor on 13.05.2015.
 */
@RestController
@RequestMapping("/vendorType")
public class VendorTypeController {
    @Autowired
    VendorTypeRepository vendorTypeRepository;

    @RequestMapping("/add")
    public VendorType addBrand(@RequestBody VendorType vendorType) {
        VendorType check = vendorTypeRepository.findByName(vendorType.getName());
        if (check == null) {
            return vendorTypeRepository.save(vendorType);
        } else {
            return check;
        }
    }

    @RequestMapping("/get")
    public List<VendorType> getVendorTypes() {
        return vendorTypeRepository.findAll();
    }
}
