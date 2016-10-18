package org.jarfar.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.beans.SamePropertyValuesAs;
import org.jarfar.model.Currency;
import org.jarfar.model.Offer;
import org.jarfar.repository.OfferRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Tests for {@link OfferController}.
 * @author Adam Faryna <a href="http://appdy.net">appdy.net</a>
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OfferControllerTest {

  @Autowired
  private OfferController controller;

  @Autowired
  private OfferRepository repository;

  private MockMvc restMvc;

  private List<Offer> preloadedOffers = new ArrayList<>();

  @Before
  public void setup() {
    this.restMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
    preloadOffers();
  }

  @After
  public void tearDown() {
    this.repository.deleteAll();
    this.preloadedOffers.clear();
    this.restMvc = null;
  }

  @Test
  public void testOfferGet() throws Exception {
    Offer offer = this.preloadedOffers.get(0);

    this.restMvc.perform(get("/api/offers/" + offer.getId()))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
      .andExpect(content().json(convertObjectToJsonString(offer)));
  }

  @Test
  public void testOffersList() throws Exception {
    this.restMvc.perform(get("/api/offers"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
      .andExpect(content().json(convertObjectToJsonString(this.preloadedOffers)));
  }

  @Test
  public void testOfferPost() throws Exception {
    Offer offer = genRandomOffer();
    offer.setId(null);

    this.restMvc.perform(post("/api/offers")
                           .content(convertObjectToJsonBytes(offer))
                           .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());

    Offer result = this.repository.findOne(Example.of(offer));
    result.setId(null);
    Assert.assertThat(offer, SamePropertyValuesAs.samePropertyValuesAs(result));
  }

  @Test
  public void testOfferPut() throws Exception {
    Offer offer = this.preloadedOffers.get(0);
    offer.setName(offer.getName() + "ABC");
    offer.setDescription(offer.getDescription() + "ABC");

    this.restMvc.perform(put("/api/offers/" + offer.getId())
                           .content(convertObjectToJsonBytes(offer))
                           .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());

    Offer result = this.repository.findOne(Example.of(offer));
    Assert.assertThat(offer, SamePropertyValuesAs.samePropertyValuesAs(result));
  }

  @Test
  public void testOfferDelete() throws Exception {
    Offer offer = this.preloadedOffers.get(1);
    this.restMvc.perform(delete("/api/offers/" + offer.getId()))
      .andExpect(status().isOk());
    Assert.assertNull(this.repository.findOne(offer.getId()));
  }

  @Test
  public void testOfferDeleteWhenOfferDontExiss() throws Exception {
    String offerId = "ab";
    this.restMvc.perform(delete("/api/offers/" + offerId))
      .andExpect(status().isBadRequest());
    Assert.assertNull(this.repository.findOne(offerId));
  }

  private void preloadOffers() {
    for (int i = 0; i != 5; i++) {
      Offer offer = genRandomOffer();
      offer = this.repository.save(offer);
      this.preloadedOffers.add(offer);
    }
  }

  private Offer genRandomOffer() {
    return new Offer("Hot Sale " + genRandomString(),
                     "This is really hot sale!" + genRandomString(),
                     genRandomCurrency(),
                     genRandomPrice());
  }

  private String convertObjectToJsonString(Object obj) throws IOException {
    return new ObjectMapper().writeValueAsString(obj);
  }

  private byte[] convertObjectToJsonBytes(Object obj) throws IOException {
    return new ObjectMapper().writeValueAsBytes(obj);
  }

  private String genRandomString() {
    return Integer.valueOf(ThreadLocalRandom.current().nextInt(0, 30)).toString();
  }

  private BigDecimal genRandomPrice() {
    return new BigDecimal(ThreadLocalRandom.current().nextInt(1, 20));
  }

  private Currency genRandomCurrency() {
    int index = ThreadLocalRandom.current().nextInt(0, Currency.values().length);
    return Currency.values()[index];
  }
}
