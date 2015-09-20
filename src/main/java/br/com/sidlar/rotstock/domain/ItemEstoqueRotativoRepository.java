package br.com.sidlar.rotstock.domain;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ItemEstoqueRotativoRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void gravaItemEstoqueRotativo(ItemEstoqueRotativo itemEstoqueRotativo) {
        em.persist(itemEstoqueRotativo);
    }
}
