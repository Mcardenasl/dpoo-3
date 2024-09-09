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
	
	private String identificador;
	
	//Metodos
	
	public Cliente(String identificador)
	{
		tiquetesSinUsar = new ArrayList<Tiquete>();
		tiquetesUsados = new ArrayList<Tiquete>();	
		this.identificador = identificador;
	}
	
	public  java.lang.String getIdentificador()
	{
		return this.identificador;
	}
	
	public abstract java.lang.String getTipoCliente();
	
	public void agregarTiquete(Tiquete tiquete)
	{
		tiquetesSinUsar.add(tiquete);
	}	
	public int calcularValorTotalTiquetes()
	{
		return (int) size(tiquetesUsados) * CalculadoraTarifas.calcularTarifa(Vuelo vuelo, null);
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
				iterator.remove()
			}
		}
	}
}
