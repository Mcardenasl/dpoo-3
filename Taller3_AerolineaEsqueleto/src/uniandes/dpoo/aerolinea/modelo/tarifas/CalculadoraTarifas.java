package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {

	public double IMPUESTO = 0.28;
		
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente)
	{
		int base = calcularCostoBase(vuelo,cliente);
		double desc = calcularPorcentajeDescuento(cliente);
		return (int) (base * desc);
	}
	
	protected int calcularDistanciaVuelo(Ruta ruta)
	{
		int distancia = Aeropuerto.calcularDistancia(ruta.getOrigen(), ruta.getDestino());
		return distancia;
	}
	
	protected int calcularValorImpuestos (int costoBase)
	{
		return (int) (costoBase * IMPUESTO);
	}
}
