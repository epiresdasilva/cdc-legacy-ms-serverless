package br.com.evandropires.legacy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class MovementDTO {

    private Integer id;
    private AccountDTO account;
    private LocalDate competence;
    private BigDecimal value;

    public MovementDTO(Movement movement) {
        this.id = movement.getId();
        this.competence = movement.getCompetence();
        this.value = movement.getValue();
    }

}