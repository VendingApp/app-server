package de.igorlueckel.vending.server.controllers;

import de.igorlueckel.vending.server.models.VendorOperator;
import de.igorlueckel.vending.server.repositories.VendorOperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Igor on 13.05.2015.
 */
@RestController
@RequestMapping("/vendorOperator")
public class VendorOperatorController {
    @Autowired
    VendorOperatorRepository vendorOperatorRepository;

    @RequestMapping("/add")
    public VendorOperator add(@RequestBody VendorOperator vendorOperator) {
        return vendorOperatorRepository.save(vendorOperator);
    }

    @RequestMapping("/get")
    public List<VendorOperator> getVendorOperators() {
        return vendorOperatorRepository.findAll();
    }

}
