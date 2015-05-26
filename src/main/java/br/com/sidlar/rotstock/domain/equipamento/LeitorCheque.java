package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.Local;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LeitorCheque")
public class LeitorCheque extends Equipamento {

    public LeitorCheque() {
        super();
    }

    public LeitorCheque(String serial, String fabricante, String modelo, boolean ativo, Local local, Proprietario proprietario) {
        super(serial, fabricante, modelo, ativo, local, proprietario);
    }
}
