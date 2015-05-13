package de.igorlueckel.vending.server.repositories;

import de.igorlueckel.vending.server.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Igor on 13.05.2015.
 */
@Transactional
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    /**
     *
     * @param latitude1 latitude minimum
     * @param latitude2 latitude maximum
     * @param longitude1 longitude minimum
     * @param longitude2 longitude maximum
     * @return Returns a list of vendors in the given rectangle
     */
    List<Vendor> findByLatitudeBetweenAndLongitudeBetween(double latitude1, double latitude2, double longitude1, double longitude2);
}
