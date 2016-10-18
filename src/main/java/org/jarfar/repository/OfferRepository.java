package org.jarfar.repository;

import org.jarfar.model.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Adam Faryna <a href="http://appdy.net">appdy.net</a>
 */
public interface OfferRepository extends MongoRepository<Offer, String> {}
