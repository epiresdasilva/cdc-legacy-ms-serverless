package br.com.evandropires.legacy;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@Setter
public class MovementDTO {

    private Integer id;
    private AccountDTO account;
    private LocalDate competence;
    private BigDecimal value;
}