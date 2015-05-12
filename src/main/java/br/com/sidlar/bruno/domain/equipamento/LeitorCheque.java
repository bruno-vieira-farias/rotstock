package br.com.sidlar.bruno.domain.equipamento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LeitorCheque")
public class LeitorCheque extends Equipamento {

}
