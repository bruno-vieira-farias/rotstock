package br.com.sidlar.bruno.domain.equipamento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Teclado")
public class Teclado extends Equipamento{
    private Enum<TipoConexao> tipoConexao;
}
