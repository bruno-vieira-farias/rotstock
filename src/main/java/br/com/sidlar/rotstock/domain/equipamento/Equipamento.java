package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.Local;
import org.joda.time.DateTime;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="equipamento")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String serial;
    private String fabricante;
    private String modelo;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dataAquisicao;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dataDesativacao;

    @ManyToOne
    @JoinColumn(name="id_local")
    private Local local;

    @Enumerated(EnumType.STRING)
    private Proprietario proprietario;


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
