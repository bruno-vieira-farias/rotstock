package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.Local;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Computador")
public class Computador extends Equipamento {
    @Enumerated(EnumType.STRING)
    private Processador processador;

    @Enumerated(EnumType.STRING)
    private Memoria memoria;

    @Enumerated(EnumType.STRING)
    private Hd hd;

    public Computador() {
    }

    public Computador(String serial, Fabricante fabricante, String modelo, boolean ativo, Local local, Proprietario proprietario, Processador processador, Memoria memoria, Hd hd) {
        super(serial, fabricante, modelo, ativo, local, proprietario);
        this.processador = processador;
        this.memoria = memoria;
        this.hd = hd;
    }
}
