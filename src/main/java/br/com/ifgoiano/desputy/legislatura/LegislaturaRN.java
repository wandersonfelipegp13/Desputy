package br.com.ifgoiano.desputy.legislatura;

import java.util.List;

import br.com.ifgoiano.desputy.usuario.Usuario;
import br.com.ifgoiano.desputy.util.DAOFactory;

public class LegislaturaRN {

	private LegislaturaDAO legislaturaDAO;

	public LegislaturaRN() {
		this.legislaturaDAO = DAOFactory.criarLegislaturaDAO();
	}
	
	public Legislatura carregar(Integer codigo) {
		return this.legislaturaDAO.carregar(codigo);
	}
	
	public void salvar(Legislatura legislatura) {
		Integer codigo = legislatura.getIdLegislatura();
		if (codigo == null || codigo == 0)
			this.legislaturaDAO.salvar(legislatura);
		else
			this.legislaturaDAO.atualizar(legislatura);
	}

	public void excluir(Legislatura legislatura) {
		this.legislaturaDAO.excluir(legislatura);
	}

	public List<Legislatura> listar() {
		return this.legislaturaDAO.listar();
	}
	
	public List<Legislatura> listarPorUsuario(Usuario usuario) {
		return this.legislaturaDAO.listarPorUsuario(usuario);
	}
	
}
