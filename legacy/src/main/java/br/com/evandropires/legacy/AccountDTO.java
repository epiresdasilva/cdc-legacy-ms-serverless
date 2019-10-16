package br.com.evandropires.legacy;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountDTO {

    private Integer id;
    private Integer branch;
    private Integer account;
    private String name;
    private BigDecimal balance;
}
