package util;

import mvc.modelo.dao.daoimplementations.stream.PaisDAOImpFileStream;
import mvc.modelo.dao.daoimplementations.stream.ProvinciasDAOImpFileStream;
import mvc.modelo.dao.factories.AeropuertoDAOFactory;
import mvc.modelo.dao.factories.ImpType;
import mvc.modelo.dao.idaos.AeropuertoDAO;
import mvc.modelo.dominio.Aeropuerto;
import mvc.modelo.dominio.Pais;
import mvc.modelo.dominio.Provincia;

public class AeropuertoHelper {
	
	private static AeropuertoDAO aeropuertos;
	private static PaisDAOImpFileStream paises;
	private static ProvinciasDAOImpFileStream provincias;
	
	static {
		aeropuertos =  AeropuertoDAOFactory.getAeropuertoDAO(ImpType.STREAM);
		paises = new PaisDAOImpFileStream();
		provincias = new ProvinciasDAOImpFileStream();
	}
	
	public static void addAeropuertos() {
		if(aeropuertos.getAll().isEmpty()) {
			Pais pais = new Pais(1, "Algeria");
			Provincia provincia = new Provincia(1, "Annaba");
			aeropuertos.agregarAeropuerto(new Aeropuerto("AAE", "Les Salines", provincia, pais));
			pais = new Pais(2, "Denmark");
			provincia = new Provincia(2, "Aalborg");
			aeropuertos.agregarAeropuerto(new Aeropuerto("AAL", "Aalborg", provincia, pais));
		}
	}
}
