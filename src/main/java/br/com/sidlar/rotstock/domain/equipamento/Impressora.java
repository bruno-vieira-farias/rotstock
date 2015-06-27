package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.Local;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Impressora")
public class Impressora extends Equipamento{
    private Boolean colorida;

    @Enumerated(EnumType.STRING)
    private TipoImpressora tipoImpressora;

    public Impressora() {
    }

    public Impressora(String serial, Fabricante fabricante, String modelo, boolean ativo, Local local, Proprietario proprietario, Boolean colorida, TipoImpressora tipoImpressora) {
        super(serial, fabricante, modelo, ativo, local, proprietario);
        this.colorida = colorida;
        this.tipoImpressora = tipoImpressora;
    }

    public Boolean getColorida() {
        return colorida;
    }

    public void setColorida(Boolean colorida) {
        this.colorida = colorida;
    }

    public TipoImpressora getTipoImpressora() {
        return tipoImpressora;
    }

    public void setTipoImpressora(TipoImpressora tipoImpressora) {
        this.tipoImpressora = tipoImpressora;
    }

    @Override
    public String getInformacoesEspecificas() {
        return  (colorida?"Colorida":"Preto e Branco") + " , " + tipoImpressora.getDescricao();
    }
}
