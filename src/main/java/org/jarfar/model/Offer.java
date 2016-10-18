package org.jarfar.model;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author Adam Faryna <a href="http://appdy.net">appdy.net</a>
 */
public class Offer {

  @Id
  private String id;

  @NotBlank
  private String name;

  @NotBlank
  private String description;

  @NotNull
  private Currency currency;

  @NotNull
  private BigDecimal price;

  public Offer() {}

  public Offer(String name, String description, Currency currency, BigDecimal price) {
    this.name = name;
    this.description = description;
    this.currency = currency;
    this.price = price;
  }

  @Override
  public String toString() {
    return "Offer{" +
      "id='" + id + '\'' +
      ", name='" + name + '\'' +
      ", description='" + description + '\'' +
      ", currency=" + currency +
      ", price=" + price +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Offer offer = (Offer) o;

    return getId() != null ? getId().equals(offer.getId()) : offer.getId() == null;

  }

  @Override
  public int hashCode() {
    return getId() != null ? getId().hashCode() : 0;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

}
