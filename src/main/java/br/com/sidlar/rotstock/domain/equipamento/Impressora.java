package br.com.sidlar.rotstock.domain.equipamento;


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

    public Impressora(Boolean colorida, TipoImpressora tipoImpressora) {
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
}
