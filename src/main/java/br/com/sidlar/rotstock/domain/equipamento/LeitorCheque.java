package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.Local;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LeitorCheque")
public class LeitorCheque extends Equipamento {

    public LeitorCheque() {
        super();
    }

    public LeitorCheque(Integer id, String serial, Fabricante fabricante, String modelo, boolean ativo, Local local, Proprietario proprietario) {
        super(id, serial, fabricante, modelo, ativo, local, proprietario);
    }

    @Override
    public String getInformacoesEspecificas() {
        return "";
    }

    @Override
    public TipoEquipamento getTipoEquipamento() {
        return TipoEquipamento.LEITOR_CHEQUE;
    }
}
