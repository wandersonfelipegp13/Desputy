package br.com.ifgoiano.desputy.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.ifgoiano.desputy.legislatura.Legislatura;
import br.com.ifgoiano.desputy.legislatura.LegislaturaRN;

@ManagedBean(name = "legislaturaBean")
@RequestScoped
public class LegislaturaBean {

	private Legislatura selecionada = new Legislatura();
	private List<Legislatura> lista = null;
	@ManagedProperty(value = "#{contextoBean}")
	private ContextoBean contextoBean;
	
	public String salvar() {
		this.selecionada.setUsuario(this.contextoBean.getUsuarioLogado());
		LegislaturaRN legislaturaRN = new LegislaturaRN();
		legislaturaRN.salvar(this.selecionada);
		this.selecionada = new Legislatura();
		this.lista = null;
		return null;
	}
	
	public String excluir() {
		LegislaturaRN legislaturaRN = new LegislaturaRN();
		legislaturaRN.excluir(this.selecionada);
		this.selecionada = new Legislatura();
		this.lista = null;
		return null;
	}

	public Legislatura getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Legislatura selecionada) {
		this.selecionada = selecionada;
	}

	public List<Legislatura> getLista() {
		if(this.lista == null) {
			LegislaturaRN legislaturaRN = new LegislaturaRN();
			this.lista = legislaturaRN.listarPorUsuario(this.contextoBean.getUsuarioLogado()); 
		}
		return this.lista;
	}

	public void setLista(List<Legislatura> lista) {
		this.lista = lista;
	}

	public ContextoBean getContextoBean() {
		return contextoBean;
	}

	public void setContextoBean(ContextoBean contextoBean) {
		this.contextoBean = contextoBean;
	}
	
}
