package model.beans;

import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author skuarch
 */
@Entity
@Table(name = "product" )
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private long id;
    @Column(name = "product_name",nullable = false)
    private String name;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "product_sku",nullable = true)
    private String sku;
    @Column(name = "product_price",nullable = true)
    private BigDecimal price;
    @Column(name = "product_model",nullable = true)
    private String model;
    @Column(name = "product_units",nullable = true)
    private int units;
    @Column(name = "product_manufacturer",nullable = true)
    private String manufacturer;
    @Column(name = "product_is_active",nullable = true)
    private int active;
    @Column(name = "product_discount",nullable = true)
    private int discount;
    @Column(name = "product_description",nullable = true)
    private String description;
    @Column(name = "product_is_soft_delete",nullable = true)
    private int isSoftDelete = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }    

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }    

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIsSoftDelete() {
        return isSoftDelete;
    }

    public void setIsSoftDelete(int isSoftDelete) {
        this.isSoftDelete = isSoftDelete;
    }

    @Override
    public String toString() {
        return "name=" + name + " sku=" + sku + " price=" + price + " model=" + model + " units=" + units + " manufacturer=" + manufacturer + " isActive=" + active + " discount=" + discount + " description=" + description + " isSoftDelete=" + isSoftDelete;
    }
    
}
