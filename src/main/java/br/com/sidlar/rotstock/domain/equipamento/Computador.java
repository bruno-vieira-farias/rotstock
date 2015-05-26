package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.Local;

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

    public Computador(String serial, String fabricante, String modelo, boolean ativo, Local local, Proprietario proprietario, String processador, String memoria, String hd) {
        super(serial, fabricante, modelo, ativo, local, proprietario);
        this.processador = processador;
        this.memoria = memoria;
        this.hd = hd;
    }
}
