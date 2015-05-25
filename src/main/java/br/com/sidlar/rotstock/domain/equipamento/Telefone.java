package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.Local;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Telefone")
public class Telefone extends Equipamento{
    private Boolean semFio;
    private Boolean ip;

    public Telefone() {
    }

    public Telefone(String serial, String fabricante, String modelo, Local local, Proprietario proprietario, Boolean semFio, Boolean ip) {
        super(serial, fabricante, modelo, local, proprietario);
        this.semFio = semFio;
        this.ip = ip;
    }
}
