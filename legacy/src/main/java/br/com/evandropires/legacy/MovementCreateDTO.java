package br.com.evandropires.legacy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class MovementCreateDTO {

    private Integer id;
    private Integer accountId;
    private LocalDate competence;
    private BigDecimal value;

    public Movement toEntity() {
        Movement movement = new Movement();
        Account account = new Account();
        account.setId(getAccountId());
        movement.setAccount(account);
        movement.setCompetence(getCompetence());
        movement.setValue(getValue());
        return movement;
    }
}