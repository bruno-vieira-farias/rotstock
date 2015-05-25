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

    public Teclado(String serial, String fabricante, String modelo, Local local, Proprietario proprietario, Enum<TipoConexao> tipoConexao) {
        super(serial, fabricante, modelo, local, proprietario);
        this.tipoConexao = tipoConexao;
    }
}
