package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.Local;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Monitor")
public class Monitor extends Equipamento{

    @Enumerated(EnumType.STRING)
    private Polegadas polegadas;

    public Monitor() {
    }

    public Monitor(Integer id, String serial, Fabricante fabricante, String modelo, boolean ativo, Local local, Proprietario proprietario, Polegadas polegadas) {
        super(id, serial, fabricante, modelo, ativo, local, proprietario);
        this.polegadas = polegadas;
    }

    public Polegadas getPolegadas() {
        return polegadas;
    }

    @Override
    public String getInformacoesEspecificas() {
        return polegadas.getDescricao() + " polegadas";
    }

    @Override
    public TipoEquipamento getTipoEquipamento() {
        return TipoEquipamento.MONITOR;
    }
}
