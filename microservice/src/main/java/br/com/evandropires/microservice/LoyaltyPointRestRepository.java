package br.com.evandropires.microservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "loyaltyPoint", path = "loyalty-point")
public interface LoyaltyPointRestRepository extends CrudRepository<LoyaltyPoint, Integer> {}
