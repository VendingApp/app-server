package de.igorlueckel.vending.server.repositories;

import de.igorlueckel.vending.server.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by Igor on 13.05.2015.
 */
@Transactional
public interface ReviewRepository extends JpaRepository<Review, Long>{
}
