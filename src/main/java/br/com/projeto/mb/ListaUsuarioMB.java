package br.com.projeto.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;	

import br.com.projeto.model.Usuario;
import br.com.projeto.service.UsuarioService;
import br.com.projeto.util.FacesUtil;

@Named
@ViewScoped
public class ListaUsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;

	private List<Usuario> usuarios = new ArrayList<>();

	private List<Usuario> usuariosSelecionados = new ArrayList<>();

	@PostConstruct
	public void inicializar() {
		usuarios = usuarioService.listAll();
	}

	public void excluirSelecionados() {
		for (Usuario usuario : usuariosSelecionados) {
			usuarioService.excluir(usuario);
			usuarios.remove(usuario);
		}

		FacesUtil.addInfoMessage("Usuário(s) Excluído(s) com Sucesso!");
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuariosSelecionados() {
		return usuariosSelecionados;
	}

	public void setUsuariosSelecionados(List<Usuario> usuariosSelecionados) {
		this.usuariosSelecionados = usuariosSelecionados;
	}

}
