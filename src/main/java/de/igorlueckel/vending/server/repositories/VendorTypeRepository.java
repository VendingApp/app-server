package de.igorlueckel.vending.server.repositories;

import de.igorlueckel.vending.server.models.VendorType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Igor on 13.05.2015.
 */
public interface VendorTypeRepository extends JpaRepository<VendorType, Long> {
    VendorType findByName(String name);
}
