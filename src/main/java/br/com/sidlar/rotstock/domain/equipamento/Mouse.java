package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.Local;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Mouse")
public class Mouse extends Equipamento{
    private TipoConexao tipoConexao;

    public Mouse() {
    }

    public Mouse(String serial, String fabricante, String modelo, Local local, Proprietario proprietario, TipoConexao tipoConexao) {
        super(serial, fabricante, modelo, local, proprietario);
        this.tipoConexao = tipoConexao;
    }
}
