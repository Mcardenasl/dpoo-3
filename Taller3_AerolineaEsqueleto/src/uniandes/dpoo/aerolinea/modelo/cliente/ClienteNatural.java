package uniandes.dpoo.aerolinea.modelo.cliente;


public class ClienteNatural extends Cliente{
	
	public static String NATURAL = "Natural";
	private String nombre;
	
	//Constructor
	public ClienteNatural(String nombre)
	{
		this.nombre = nombre;
	}
	public String getTipoCliente()
    {
    	return NATURAL;
    }
    
    public String getIdentificador()
    {
    	return nombre;
    }
	
}
