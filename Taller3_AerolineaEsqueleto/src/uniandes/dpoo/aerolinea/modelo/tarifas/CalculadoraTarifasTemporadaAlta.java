package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaAlta {
	
	protected int COSTO_POR_KM = 1000;
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente)
	{
		Ruta r = vuelo.getRuta();
		Aeropuerto origen = r.getOrigen();
		Aeropuerto destino = r.getDestino();
		int distancia = Aeropuerto.calcularDistancia(origen, destino);
		return COSTO_POR_KM* distancia;
	}
	
	public double calcularPorcentajeDescuento(Cliente cliente)
	{
		double DESCUENTO_PEQ = 0.02;
		double DESCUENTO_MEDIANAS = 0.1;
		double DESCUENTO_GRANDES = 0.2;
		String tipo = cliente.getTipoCliente();
		
		double no = 0.0;
		
		if (tipo.equals("Corporativo"))
			{
			ClienteCorporativo clienteCorporativo = (ClienteCorporativo) cliente;
			int tamano = clienteCorporativo.getTamanoEmpresa();
			if (tamano == 1) {
				return DESCUENTO_GRANDES;
			}
			if (tamano == 2) {
				return DESCUENTO_MEDIANAS;
			}
			else {
				return DESCUENTO_PEQ;
			}
			}
		else {
			return (double)no;
		}
	}
}
