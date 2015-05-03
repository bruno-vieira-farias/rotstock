package br.com.sidlar.bruno.infrastructure.security;

import br.com.sidlar.bruno.domain.Usuario;
import org.springframework.security.core.userdetails.User;
import java.util.Collections;

public class LoggedUser extends User {
    private final Usuario usuario;

    public LoggedUser(Usuario usuario) {
        super(usuario.getEmail(), usuario.getSenha(), Collections.emptyList());
        this.usuario = usuario;
    }

    public String getEmail() {
        return usuario.getEmail();
    }

    public String getNome() {
        return usuario.getNome();
    }
}
