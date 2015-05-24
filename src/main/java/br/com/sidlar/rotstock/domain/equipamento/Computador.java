package br.com.sidlar.rotstock.domain.equipamento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Computador")
public class Computador extends Equipamento {
    private String processador;
    private String memoria;
    private String hd;

    public Computador() {
    }

    public Computador(String processador, String memoria, String hd) {
        this.processador = processador;
        this.memoria = memoria;
        this.hd = hd;
    }
}
