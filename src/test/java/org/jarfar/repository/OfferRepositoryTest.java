package org.jarfar.repository;

import org.hamcrest.beans.SamePropertyValuesAs;
import org.jarfar.model.Currency;
import org.jarfar.model.Offer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Tests for {@link OfferRepository}.
 * @author Adam Faryna <a href="http://appdy.net">appdy.net</a>
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OfferRepositoryTest {

  @Autowired
  private OfferRepository repository;

  @Test
  public void testMongoConfigurationWorksFine() throws Exception {
    Offer offer = new Offer("ala", "ma kota", Currency.GBP, BigDecimal.TEN);
    offer = this.repository.save(offer);
    Offer result = this.repository.findOne(offer.getId());
    Assert.assertThat(offer, SamePropertyValuesAs.samePropertyValuesAs(result));
  }
}
