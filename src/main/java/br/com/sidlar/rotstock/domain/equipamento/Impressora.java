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
}
