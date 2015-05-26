package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.Local;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Teclado")
public class Teclado extends Equipamento{
    private Enum<TipoConexao> tipoConexao;

    public Teclado() {
    }

    public Teclado(String serial, String fabricante, String modelo, boolean ativo, Local local, Proprietario proprietario, Enum<TipoConexao> tipoConexao) {
        super(serial, fabricante, modelo, ativo, local, proprietario);
        this.tipoConexao = tipoConexao;
    }
}
