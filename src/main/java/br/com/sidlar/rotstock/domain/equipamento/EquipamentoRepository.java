package br.com.sidlar.rotstock.domain.equipamento;

import br.com.sidlar.rotstock.domain.Local;
import br.com.sidlar.rotstock.domain.LocalRepository;
import br.com.sidlar.rotstock.presentation.TipoEquipamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.List;

@Repository
public class EquipamentoRepository {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    LocalRepository localRepository;

    @Transactional
    public void gravaEquipamento(Equipamento equipamento) {
        em.persist(equipamento);
    }
    @Transactional
    public void alteraEquipamento(Equipamento equipamento){
        em.merge(equipamento);
    }
    public Equipamento buscaPorId(int id){
        return em.find(Equipamento.class,id);
    }
    public List<Equipamento> buscaTodos() {
            String jpql ="SELECT i FROM Equipamento i";

        return em.createQuery(jpql, Equipamento.class).getResultList();
    }
    public List<Equipamento> buscaPorLocal(Local local) {
        String jpql ="SELECT i " +
                "FROM Equipamento i WHERE i.local.id = :idLocal";

        return em.createQuery(jpql, Equipamento.class)
                .setParameter("idLocal", local.getId())
                .getResultList();
    }
    public List<Equipamento> buscaPorSerial(String serial) {
        String jpql ="SELECT i " +
                "FROM Equipamento i WHERE i.serial = :serial";

        return em.createQuery(jpql, Equipamento.class)
                .setParameter("serial",serial)
                .getResultList();
    }
    public List<Equipamento> buscaPorTipoEquipamento(Class entityClass) {
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Equipamento> criteria = builder.createQuery(Equipamento.class);
        Root<Equipamento> entityRoot = criteria.from(entityClass);
        criteria.select(entityRoot);

        return em.createQuery(criteria).getResultList();
    }
    public List<Equipamento> buscaPorTipoEquipamentoLocal(Class entityClass,Local local) {
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Equipamento> criteria = builder.createQuery(entityClass);

        Root<Equipamento> equipamento = criteria.from(entityClass);
        criteria.select(equipamento);
        criteria.where(builder.equal(equipamento.get("local").get("id"), local.getId()));

        return em.createQuery(criteria).getResultList();
    }
    @Transactional
    public void removeEquipamento(Integer id) {
        em.remove(em.find(Equipamento.class,id));
    }
}