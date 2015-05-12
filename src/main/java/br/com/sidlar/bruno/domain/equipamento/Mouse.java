package br.com.sidlar.bruno.domain.equipamento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Mouse")
public class Mouse extends Equipamento{
    private TipoConexao tipoConexao;
}
