package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;

public abstract class Cliente {
	//Atributos
	protected List<Tiquete> tiquetesSinUsar;
	
	private List<Tiquete> tiquetesUsados;
		
	//Metodos
	
	public Cliente()
	{
		tiquetesSinUsar = new ArrayList<Tiquete>();
		tiquetesUsados = new ArrayList<Tiquete>();	
	}
	
	public  abstract String getIdentificador();
	
	public abstract java.lang.String getTipoCliente();
	
	public void agregarTiquete(Tiquete tiquete)
	{
		tiquetesSinUsar.add(tiquete);
	}	
	public int calcularValorTotalTiquetes()
	{
		CalculadoraTarifas calculadoraTarifas = (CalculadoraTarifas);
		return (int) tiquetesUsados.size();
	}
	
	public void usarTiquetes(Vuelo vuelo)
	{
		Iterator<Tiquete> iterator = tiquetesSinUsar.iterator();
		while (iterator.hasNext())
		{
			Tiquete tiquete = iterator.next();
			if (tiquete.getVuelo().equals(vuelo));
			{
				tiquetesUsados.add(tiquete);
				iterator.remove();
			}
		}
	}
}
