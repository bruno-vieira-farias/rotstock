package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.Local;
import org.joda.time.DateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Monitor")
public class Monitor extends Equipamento{

    @Enumerated(EnumType.STRING)
    private Polegadas polegadas;

    public Monitor() {
    }

    public Monitor(String serial, String fabricante, String modelo, Local local, Proprietario proprietario, Polegadas polegadas) {
        super(serial, fabricante, modelo, local, proprietario);
        this.polegadas = polegadas;
    }




}
