package de.igorlueckel.vending.server.repositories;

import de.igorlueckel.vending.server.models.VendorOperator;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Igor on 13.05.2015.
 */
public interface VendorOperatorRepository extends JpaRepository<VendorOperator, Long> {
}
