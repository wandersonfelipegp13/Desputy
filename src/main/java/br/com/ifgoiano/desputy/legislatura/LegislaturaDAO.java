package br.com.ifgoiano.desputy.legislatura;
import java.util.List;

import br.com.ifgoiano.desputy.usuario.Usuario;

public interface LegislaturaDAO {
	
	public void salvar(Legislatura legislatura);

	public void atualizar(Legislatura legislatura);

	public void excluir(Legislatura legislatura);

	public Legislatura carregar(Integer codigo);

	public List<Legislatura> listar();
	
	public List<Legislatura> listarPorUsuario(Usuario usuario);

}
