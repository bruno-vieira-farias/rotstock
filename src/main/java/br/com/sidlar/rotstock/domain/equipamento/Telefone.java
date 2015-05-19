package br.com.sidlar.rotstock.domain.equipamento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Telefone")
public class Telefone extends Equipamento{
    private Boolean semFio;
    private Boolean ip;
}
