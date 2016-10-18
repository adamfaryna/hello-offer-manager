package org.jarfar.model;

/**
 * Enum for currency symbols.
 * @author Adam Faryna <a href="http://appdy.net">appdy.net</a>
 */
public enum Currency {
  GBP("£"),
  USD("$"),
  PLN("zł");

  private String mark;

  Currency(String mark) {
    this.mark = mark;
  }

  public String getMark() {
    return mark;
  }
}
