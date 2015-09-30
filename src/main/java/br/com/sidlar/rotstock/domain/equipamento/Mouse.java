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

    public Mouse(Integer id, String serial, Fabricante fabricante, String modelo, boolean ativo, Local local, Proprietario proprietario, TipoConexao tipoConexao) {
        super(id, serial, fabricante, modelo, ativo, local, proprietario);
        this.tipoConexao = tipoConexao;
    }

    public TipoConexao getTipoConexao() {
        return tipoConexao;
    }

    @Override
    public String getInformacoesEspecificas() {
        return "Conexão " + tipoConexao.getDescricao();
    }

    @Override
    public TipoEquipamento getTipoEquipamento() {
        return TipoEquipamento.MOUSE;
    }
}
