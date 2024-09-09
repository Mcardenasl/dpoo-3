package uniandes.dpoo.aerolinea.modelo.cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;


public class ClienteNatural extends Cliente{
	
	public static String NATURAL = "Natural";
	private String nombre;
	
	//Constructor
	public ClienteNatural(String nombre)
	{
		this.nombre = nombre;
	}
	public java.lang.String getIdentificador()
	{
		return Cliente.getIdentificador();
	}
	
	
	
}
