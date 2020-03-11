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

@Entity
public class Driver {
    private Integer id;
    private String name;
    private Byte suspended;
    private Byte revoked;
    private Date birthday;
    private String license;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "suspended")
    public Byte getSuspended() {
        return suspended;
    }

    public void setSuspended(Byte suspended) {
        this.suspended = suspended;
    }

    @Basic
    @Column(name = "revoked")
    public Byte getRevoked() {
        return revoked;
    }

    public void setRevoked(Byte revoked) {
        this.revoked = revoked;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "license")
    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id) &&
                Objects.equals(name, driver.name) &&
                Objects.equals(suspended, driver.suspended) &&
                Objects.equals(revoked, driver.revoked) &&
                Objects.equals(birthday, driver.birthday) &&
                Objects.equals(license, driver.license);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, suspended, revoked, birthday, license);
    }
}
