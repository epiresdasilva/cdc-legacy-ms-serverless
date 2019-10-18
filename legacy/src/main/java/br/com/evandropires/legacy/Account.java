package br.com.evandropires.legacy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts", schema = "banking")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer branch;

    @Column
    private Integer account;

    @Column
    private String name;

    @Column
    private BigDecimal balance;

}
