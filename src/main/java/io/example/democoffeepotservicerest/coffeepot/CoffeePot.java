package io.example.democoffeepotservicerest.coffeepot;

import java.time.LocalDate;
import java.util.Objects;

// TODO: add @ Entity and @Table
public class CoffeePot {

  private Long id;
  private String brand;
  private String sku;
  private LocalDate releaseDate;
  private int age;

  public CoffeePot() {
  }

  public CoffeePot(String brand, String sku, LocalDate releaseDate, int age) {
    this.brand = brand;
    this.sku = sku;
    this.releaseDate = releaseDate;
    this.age = age;
  }

  public CoffeePot(Long id, String brand, String sku, LocalDate releaseDate, int age) {
    this.id = id;
    this.brand = brand;
    this.sku = sku;
    this.releaseDate = releaseDate;
    this.age = age;
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
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "CoffeePot{" +
        "id=" + id +
        ", brand='" + brand + '\'' +
        ", sku='" + sku + '\'' +
        ", releaseDate=" + releaseDate +
        ", age=" + age +
        '}';
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
    return age == coffeePot.age && id.equals(coffeePot.id) && brand.equals(coffeePot.brand)
        && sku.equals(coffeePot.sku) && releaseDate.equals(coffeePot.releaseDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, brand, sku, releaseDate, age);
  }
}
