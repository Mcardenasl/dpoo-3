package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.Map;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	private String fecha;
	
	private Avion avion;
	private Ruta ruta;
	private Map<String, Tiquete> tiquetes;
	
	public Vuelo(Ruta ruta, String fecha, Avion avion)
	{
		this.ruta = ruta;
		this.fecha = fecha;
		this.avion = avion;
	}
	
	public Ruta getRuta()
	{
		return this.ruta;
	}
	
	public String getFecha()
	{
		return this.fecha;
	}
	
	public Avion getAvion()
	{
		return this.avion;
	}
	
	public Collection<Tiquete> getTiquetes()
	{
		return tiquetes.values();
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException
	{
		int precio = calculadora.calcularTarifa(this,cliente);
		int total = precio * cantidad;
		
		for (int i = 0; i < cantidad; i++) {
			String id = generarIdTiquete();
			Tiquete tiquete = new Tiquete(id, cliente, precio);
			tiquetes.put(id, tiquete);
		}
		
		return total;
	}
	
	public boolean equals(java.lang.Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
