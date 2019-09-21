package br.com.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.projeto.exception.NegocioException;
import br.com.projeto.model.Usuario;

public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Usuario salvar(Usuario usuario) {
		return manager.merge(usuario);
	}

	public void excluir(Usuario usuario) {
		try {
			usuario = porId(usuario.getId());
			manager.remove(usuario);
			manager.flush();
		} catch (Exception e) {
			throw new NegocioException("Usuário Não Pode Ser Excluído!");
		}
	}

	public Usuario porId(Long id) {
		return manager.find(Usuario.class, id);
	}

	public List<Usuario> listAll() {
		return manager.createNativeQuery("SELECT * FROM Usuario", Usuario.class).getResultList();
	}
}
