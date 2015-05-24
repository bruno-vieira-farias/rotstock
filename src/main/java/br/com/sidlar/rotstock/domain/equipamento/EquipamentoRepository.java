package br.com.sidlar.rotstock.domain.equipamento;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EquipamentoRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void gravaEquipamento(Equipamento equipamento) {
        em.persist(equipamento);
    }

    public Equipamento buscaPorId(int id){
        return em.find(Equipamento.class,id);
    }
}
