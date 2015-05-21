package de.igorlueckel.vending.server.controllers;

import de.igorlueckel.vending.server.models.Review;
import de.igorlueckel.vending.server.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Igor on 13.05.2015.
 */
@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ReviewRepository reviewRepository;

    @RequestMapping("/template")
    public Review getTemplate() {
        return new Review();
    }
}
