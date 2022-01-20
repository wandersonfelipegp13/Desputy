package br.com.ifgoiano.desputy.deputado;

import java.util.List;

import br.com.ifgoiano.desputy.usuario.Usuario;

public interface DeputadoDAO {
	
	public void salvar(Deputado deputado);

	public void atualizar(Deputado deputado);

	public void excluir(Deputado deputado);

	public Deputado carregar(Integer codigo);

	public List<Deputado> listar();
	
	public List<Deputado> listarPorUsuario(Usuario usuario);
	
	public List<Deputado> listarPorEstado(String estado);
	
	public List<EstadoDeputado> listarEstadosPopulosos();
	
	
}
