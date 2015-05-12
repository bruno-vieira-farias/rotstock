package br.com.sidlar.bruno.domain.equipamento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Computador")
public class Computador extends Equipamento {
    private String processador;
    private String memoria;
    private String hd;
}
