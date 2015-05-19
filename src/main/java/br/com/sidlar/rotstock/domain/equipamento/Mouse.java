package br.com.sidlar.rotstock.domain.equipamento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Mouse")
public class Mouse extends Equipamento{
    private TipoConexao tipoConexao;
}
