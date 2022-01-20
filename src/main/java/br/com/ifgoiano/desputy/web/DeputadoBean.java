package br.com.ifgoiano.desputy.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.ifgoiano.desputy.deputado.Deputado;
import br.com.ifgoiano.desputy.deputado.DeputadoRN;
import br.com.ifgoiano.desputy.deputado.EstadoDeputado;

@ManagedBean
@RequestScoped
public class DeputadoBean {
	
	private Deputado selecionada = new Deputado();
	private List<Deputado> lista = null;
	@ManagedProperty(value = "#{contextoBean}")
	private ContextoBean contextoBean;
	
	/**
	 * Representa o gr�fico de barras
	 */
	private BarChartModel deputadosBarra;

	public DeputadoBean() {
		
		this.deputadosBarra = new BarChartModel();
		
		List<EstadoDeputado> deps = new DeputadoRN().listarEstadosPopulosos();
		
		/**
		 * Um controle, para que apenas os 5 estados com mais deputados sejam exibidos.
		 */
		for (int i = 0; i < 5; i++) {
			
			EstadoDeputado dep;
			
			try {
				dep = deps.get(i);
			} catch (Exception e) {
				break;
			}
			
			ChartSeries deputadoseries = new ChartSeries();
			
			deputadoseries.setLabel(dep.getUfnascimento());
			deputadoseries.set(dep.getUfnascimento(), dep.getDeputados());
			this.deputadosBarra.addSeries(deputadoseries);
		}
		
		this.deputadosBarra.setTitle("Grafico dos Deputados do pa�s por estado");
		this.deputadosBarra.setLegendPosition("w");

		Axis xAxis = this.deputadosBarra.getAxis(AxisType.X);
		xAxis.setLabel("Estado");

		Axis yAxis = this.deputadosBarra.getAxis(AxisType.Y);
		yAxis.setLabel("Deputados");
		// yAxis.setMin(0);
		// yAxis.setMax(48000000);
		
	}
	
	public BarChartModel getDeputadoColunas() {
		return this.deputadosBarra;
	}

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
