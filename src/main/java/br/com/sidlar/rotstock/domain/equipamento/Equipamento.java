package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.Local;
import org.joda.time.DateTime;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="equipamento")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discriminator", discriminatorType = DiscriminatorType.STRING)
abstract public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String serial;
    private String fabricante;
    private String modelo;

    private Boolean isAtivo = Boolean.TRUE;

    @ManyToOne
    @JoinColumn(name="id_local")
    private Local local;

    @Enumerated(EnumType.STRING)
    private Proprietario proprietario;

    public Equipamento() {
    }

    public Equipamento(String serial, String fabricante, String modelo, Local local, Proprietario proprietario) {
        this.serial = serial;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.local = local;
        this.proprietario = proprietario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipamento)) return false;
        Equipamento that = (Equipamento) o;
        return Objects.equals(serial, that.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serial);
    }
}
