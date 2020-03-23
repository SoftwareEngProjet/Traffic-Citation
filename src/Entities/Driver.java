/******************************************************************************
 * File Name: Driver.java                                                     *
 * Initial Version                                                            *
 ******************************************************************************
 * Driver object which holds mainly all the related data                      *
 * (c) 2020 Uncanny-Varsett Traffic Citation                                  *
 ******************************************************************************
 * Created By: Matt Ferlaino                                                  *
 * Date:       Mar 11th 2020                                                  *
 ******************************************************************************/

// Packages
package Entities;

// Imports
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;
import java.util.ArrayList;

@Entity
public class Driver {
    // Variables
    private Integer id;
    private String name;
    private Byte suspended;
    private Byte revoked;
    private Date birthday;
    private String license;
    private ArrayList<Offense> offenses;
    private School trafficSchool;

    // No-arg Constructor
    public Driver() {
        id = 0;
        name = "";
        suspended = 0;
        revoked = 0;
        birthday = new Date(new java.util.Date().getDate());
        offenses = new ArrayList<Offense>();
        trafficSchool = new School();
        license = "";
    }

    // Multi-arg Constructor
    public Driver(Integer id, String name, Byte suspended, Byte revoked, Date birthday, String license) {
        this.id = id;
        this.name = name;
        this.suspended = suspended;
        this.revoked = revoked;
        this.birthday = birthday;
        this.license = license;
        offenses = new ArrayList<Offense>();
        trafficSchool = new School();
    }

    /* --- Class Methods Below ---
     * 1. ID
     * 2. Name
     * 3. Suspended
     * 4. Revoked
     * 5. Birthday
     * 6. License
     * 7. Other
     */

    // ID
    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Name
    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Suspended
    @Basic
    @Column(name = "suspended")
    public Byte getSuspended() {
        return suspended;
    }

    public void setSuspended(Byte suspended) {
        this.suspended = suspended;
    }

    // Revoked
    @Basic
    @Column(name = "revoked")
    public Byte getRevoked() {
        return revoked;
    }

    public void setRevoked(Byte revoked) {
        this.revoked = revoked;
    }

    // Birthday
    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    // Licenses
    @Basic
    @Column(name = "license")
    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    // Offense
    public ArrayList<Offense> getOffenses() {
        return offenses;
    }

    public void setOffenses(ArrayList<Offense> offenses) {
        this.offenses = offenses;
    }

    // Other
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Driver driver = (Driver) obj;
        return Objects.equals(id, driver.id) &&
                Objects.equals(name, driver.name) &&
                Objects.equals(suspended, driver.suspended) &&
                Objects.equals(revoked, driver.revoked) &&
                Objects.equals(birthday, driver.birthday) &&
                Objects.equals(license, driver.license);
    }
}
