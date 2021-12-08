package br.com.ifgoiano.desputy.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.ifgoiano.desputy.deputado.Deputado;
import br.com.ifgoiano.desputy.deputado.DeputadoRN;

@ManagedBean
@RequestScoped
public class DeputadoBean {
	
	private Deputado selecionada = new Deputado();
	private List<Deputado> lista = null;
	@ManagedProperty(value = "#{contextoBean}")
	private ContextoBean contextoBean;

	public String salvar() {
		this.selecionada.setUsuario(this.contextoBean.getUsuarioLogado());
		DeputadoRN deputadoRN = new DeputadoRN();
		deputadoRN.salvar(this.selecionada);
		this.selecionada = new Deputado();
		this.lista = null;
		return null;
	}

	public String excluir() {
		DeputadoRN deputadoRN = new DeputadoRN();
		deputadoRN.excluir(this.selecionada);
		this.selecionada = new Deputado();
		this.lista = null;
		return null;
	}

	public Deputado getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Deputado selecionada) {
		this.selecionada = selecionada;
	}

	public List<Deputado> getLista() {
		if (this.lista == null) {
			DeputadoRN deputadoRN = new DeputadoRN();
			this.lista = deputadoRN.listarPorUsuario(this.contextoBean.getUsuarioLogado());
		}
		return this.lista;

	}

	public void setLista(List<Deputado> lista) {
		this.lista = lista;
	}

	public ContextoBean getContextoBean() {
		return contextoBean;
	}

	public void setContextoBean(ContextoBean contextoBean) {
		this.contextoBean = contextoBean;
	}

}
