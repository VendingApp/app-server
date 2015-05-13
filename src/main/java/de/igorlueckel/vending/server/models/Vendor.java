package de.igorlueckel.vending.server.models;

//import com.vividsolutions.jts.geom.Point;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Igor on 13.05.2015.
 */
@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull
    double latitude;

    @NotNull
    double longitude;

    String address;

    String status;

    //String images;

    String description;

    @ManyToOne
    VendorType vendorType;

    @ManyToOne
    VendorOperator vendorOperator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VendorType getVendorType() {
        return vendorType;
    }

    public void setVendorType(VendorType vendorType) {
        this.vendorType = vendorType;
    }

    public VendorOperator getVendorOperator() {
        return vendorOperator;
    }

    public void setVendorOperator(VendorOperator vendorOperator) {
        this.vendorOperator = vendorOperator;
    }
}
