package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Cliente clienteComprador;
	private Vuelo vuelo;
	
	public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa)
	{
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.clienteComprador = clienteComprador;
		this.vuelo = vuelo;
	}
	
	public Cliente getCliente()
	{
		return this.clienteComprador;
	}
	
	public Vuelo getVuelo()
	{
		return this.vuelo;
	}
	
	public String getCodigo()
	{
		return this.codigo;
	}
	
	public int getTarifa()
	{
		return this.tarifa;
	}
	
	public void marcarComousado()
	{
		usado = true;
	}
	
	public boolean esUsado()
	{
		return usado;
	}
}
