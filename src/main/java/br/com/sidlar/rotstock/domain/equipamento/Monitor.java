package br.com.sidlar.rotstock.domain.equipamento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Monitor")
public class Monitor extends Equipamento{

    @Enumerated(EnumType.STRING)
    private Polegadas polegadas;
}
