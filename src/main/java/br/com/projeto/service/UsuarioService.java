package br.com.projeto.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.projeto.dao.UsuarioDAO;
import br.com.projeto.model.Usuario;
import br.com.projeto.util.Transactional;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Transactional
	public void salvar(Usuario usuario) {
		usuarioDAO.salvar(usuario);
	}

	@Transactional
	public void excluir(Usuario usuario) {
		usuarioDAO.excluir(usuario);
	}

	public List<Usuario> listAll() {
		return usuarioDAO.listAll();
	}

	public Usuario porId(Long id) {
		return usuarioDAO.porId(id);
	}
}
