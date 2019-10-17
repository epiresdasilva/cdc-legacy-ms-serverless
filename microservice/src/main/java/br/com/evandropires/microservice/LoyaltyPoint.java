package br.com.evandropires.microservice;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoyaltyPoint {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "account_id")
  private Integer accountId;

  @Column
  private BigDecimal points;
}
