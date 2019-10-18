package br.com.evandropires.microservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "loyaltypoints", schema = "banking")
@Getter
@Setter
@NoArgsConstructor
public class LoyaltyPoint {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "account_id")
  private Integer accountId;

  @Column private BigDecimal points;
}
