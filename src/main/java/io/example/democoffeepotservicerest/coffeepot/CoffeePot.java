package io.example.democoffeepotservicerest.coffeepot;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table
@ApiModel(description = "Details about coffee pots.  NOTE: Id and age are generated values")
public class CoffeePot {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(notes = "Unique ID of the coffee pot. Auto generated from the DB")
  private Long id;

  @NotBlank(message = "Brand is required")
  @ApiModelProperty(
      notes = "The brand name of the coffee pot ie Ninja, Coffee Mate, ect",
      example = "Ninja")
  private String brand;

  @NotNull(message = "Sku cannot be null")
  @Pattern(
      message = "Sku must match the pattern XXXX-XXXXXXXX alphanumeric",
      regexp = "^[A-Z0-9]{4}-[A-Z0-9]{8}$")
  @ApiModelProperty(
      notes =
          "Unique SKU of the coffee pot.  Sku must match the pattern XXXX-XXXXXXXX alphanumeric",
      example = "CXFV-JY3MWVDU")
  private String sku;

  @NotNull(message = "Release is required")
  @ApiModelProperty(notes = "When did the coffee pot come out?", example = "2003-01-30")
  private LocalDate releaseDate;

  @ApiModelProperty(notes = "Transient and generated from the API")
  @Transient
  private int age;

  public CoffeePot() {}

  public CoffeePot(String brand, String sku, LocalDate releaseDate) {
    this.brand = brand;
    this.sku = sku;
    this.releaseDate = releaseDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
  }

  public int getAge() {
    return Period.between(this.releaseDate, LocalDate.now()).getYears();
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "CoffeePot{"
        + "id="
        + id
        + ", brand='"
        + brand
        + '\''
        + ", sku='"
        + sku
        + '\''
        + ", releaseDate="
        + releaseDate
        + ", age="
        + age
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CoffeePot coffeePot = (CoffeePot) o;
    return age == coffeePot.age
        && id.equals(coffeePot.id)
        && brand.equals(coffeePot.brand)
        && sku.equals(coffeePot.sku)
        && releaseDate.equals(coffeePot.releaseDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, brand, sku, releaseDate, age);
  }
}
