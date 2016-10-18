package org.jarfar.web.api;

import org.jarfar.model.Offer;
import org.jarfar.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * {@link Offer} REST API.
 * @author Adam Faryna <a href="http://www.softwaremind.pl">SoftwareMind</a>
 */
@RestController
public class OfferController {

  @Autowired
  private OfferRepository repository;

  @GetMapping(value = "/api/offers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Offer offerGet(@PathVariable String id) {
    return repository.findOne(id);
  }

  @GetMapping(value = "/api/offers", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Offer> offersList() {
    return repository.findAll();
  }

  @PostMapping(value = "/api/offers", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  public void offerPost(@Valid @RequestBody Offer offer) {
    repository.save(offer);
  }

  @PutMapping(value = "/api/offers/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  public void offerPut(@PathVariable String id, @Valid @RequestBody Offer offer) {
    offer.setId(id);
    repository.save(offer);
  }

  @DeleteMapping(value = "/api/offers/{id}")
  public ResponseEntity offerDelete(@PathVariable String id) {
    if (repository.exists(id)) {
      repository.delete(id);
      return ResponseEntity.ok().build();

    } else {
      return ResponseEntity.badRequest().build();
    }
  }
}
