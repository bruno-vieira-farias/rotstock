package br.com.sidlar.rotstock.domain.equipamento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Teclado")
public class Teclado extends Equipamento{
    private Enum<TipoConexao> tipoConexao;
}