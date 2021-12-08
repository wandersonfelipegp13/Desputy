package br.com.ifgoiano.desputy.deputado;

import java.util.List;

import br.com.ifgoiano.desputy.usuario.Usuario;
import br.com.ifgoiano.desputy.util.DAOFactory;

public class DeputadoRN {
	
	private DeputadoDAO deputadoDAO;

	public DeputadoRN() {
		this.deputadoDAO = DAOFactory.criarDeputadoDAO();
	}

	public Deputado carregar(Integer codigo) {
		return this.deputadoDAO.carregar(codigo);
	}

	public void salvar(Deputado deputado) {
		Integer codigo = deputado.getId();
		if (codigo == null || codigo == 0) {
			this.deputadoDAO.salvar(deputado);
		} else {
			this.deputadoDAO.atualizar(deputado);
		}
	}

	public void excluir(Deputado deputado) {
		this.deputadoDAO.excluir(deputado);
	}

	public List<Deputado> listar() {
		return this.deputadoDAO.listar();
	}
	
	public List<Deputado> listarPorUsuario(Usuario usuario) {
		return this.deputadoDAO.listarPorUsuario(usuario);
	}
	
}