package br.com.sidlar.rotstock.domain.Usuario;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class UsuarioRepository {

    @PersistenceContext
    private EntityManager em;

    public Usuario buscaPorId(int id) {
        return em.find(Usuario.class, id);
    }

    public Optional<Usuario> buscaPorEmail(String email) {
        String jpql =
                " SELECT u "
                        + " FROM Usuario u"
                        + " WHERE u.email = :email";

        try {
            return Optional.of(
                    em.createQuery(jpql, Usuario.class)
                            .setParameter("email", email)
                            .getSingleResult()
            );
        }
        catch(NoResultException e) {
            return Optional.empty();
        }
    }
    public void adiciona(Usuario usuario) {
        em.persist(usuario);
    }
}