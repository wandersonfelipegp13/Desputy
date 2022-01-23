package br.com.ifgoiano.desputy.popularbd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import br.com.ifgoiano.desputy.deputado.Deputado;
import br.com.ifgoiano.desputy.deputado.DeputadoRN;
import br.com.ifgoiano.desputy.xmlhandler.DeputadoHandler;

public class PopularDeputado {
	
	private List<Deputado> deputados;
	
	private void pegaDados() {
		
		deputados = new ArrayList<Deputado>();
	
		try {

			DeputadoHandler dom = new DeputadoHandler();

			dom.fazerParsing("D:/deputados.xml");

			deputados = dom.getDeputados();
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			StringBuilder msg = new StringBuilder();
			msg.append("Erro no pegaDados() de PopularDeputado:\n");
			msg.append(e.getMessage() + "\n");
			msg.append(e.toString());
			System.out.println(msg);
		}

	}
	
	public List<Deputado> getDeputados() {
		return deputados;
	}

	public void insereDados() {
		
		this.pegaDados();
		
		DeputadoRN depRN = new DeputadoRN();
		
		for (int i = 0; i < deputados.size(); i++)
			depRN.salvar(deputados.get(i));
		
	}
	
	

}
