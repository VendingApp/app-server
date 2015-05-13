package de.igorlueckel.vending.server.controllers;

import de.igorlueckel.vending.server.models.Brand;
import de.igorlueckel.vending.server.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Igor on 13.05.2015.
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandRepository brandRepository;

    @RequestMapping("/add")
    public Brand addBrand(@RequestBody Brand brand) {
        Brand check = brandRepository.findByName(brand.getName());
        if (check == null) {
            return brandRepository.save(brand);
        } else {
            return check;
        }
    }

    @RequestMapping("/get")
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }
}
