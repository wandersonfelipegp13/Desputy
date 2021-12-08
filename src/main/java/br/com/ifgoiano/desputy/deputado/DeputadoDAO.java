package br.com.ifgoiano.desputy.deputado;

import java.util.List;

public interface DeputadoDAO {
	
	public void salvar(Deputado deputado);

	public void atualizar(Deputado deputado);

	public void excluir(Deputado deputado);

	public Deputado carregar(Integer codigo);

	public List<Deputado> listar();
	
}
