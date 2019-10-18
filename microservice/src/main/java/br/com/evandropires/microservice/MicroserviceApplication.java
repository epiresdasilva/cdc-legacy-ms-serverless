package br.com.evandropires.microservice;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@EnableBinding(Processor.class)
@SpringBootApplication
@Slf4j
public class MicroserviceApplication {

  @Autowired private LoyaltyPointRestRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(MicroserviceApplication.class, args);
  }

  @Transactional
  @StreamListener(Processor.INPUT)
  public void enrichLogMessage(String message) {
    log.info("Movement received: " + message);
    var json = new JSONObject(message);
    var accountId = json.getJSONObject("payload").getJSONObject("after").getInt("account_id");
    var loyaltyPoint = new LoyaltyPoint();
    loyaltyPoint.setAccountId(accountId);
    loyaltyPoint.setPoints(BigDecimal.ONE);
    repository.save(loyaltyPoint);
    log.info("Loyalty Point saved.");
  }
}
