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

    public AccountDTO(Account account) {
        this.id = account.getId();
        this.branch = account.getBranch();
        this.account = account.getAccount();
        this.name = account.getName();
        this.balance = account.getBalance();
    }
}
