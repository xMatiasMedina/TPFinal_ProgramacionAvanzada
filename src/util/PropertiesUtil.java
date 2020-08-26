package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PropertiesUtil {
	
		private static Properties properties = new Properties();
		private static PropertiesUtil objeto = null;
		 
		private PropertiesUtil() throws FileNotFoundException , IOException
		{
			properties.load(new FileReader("config.properties"));
		}
		
		public static PropertiesUtil getInstance() throws FileNotFoundException, IOException
		{
			if (objeto == null)
				objeto = new PropertiesUtil();
			return objeto;
		}

		//Éste no es un método de clase sino de instancia, es singleton
		public String obtenerPathLineaAereaStream() throws IOException, FileNotFoundException{
			return properties.getProperty("pathLineaAereaStream");
		}

		public String obtenerPathClienteStream() throws IOException, FileNotFoundException{
			return properties.getProperty("pathClienteStream");
		}
		
		public String obtenerPathAeropuertoStream() throws IOException, FileNotFoundException{
			return properties.getProperty("pathAeropuertoStream");
		}
		
		public String obtenerPathVentaStream() throws IOException, FileNotFoundException{
			return properties.getProperty("pathVentaStream");
		}
		
		public String obtenerPathVueloStream() throws IOException, FileNotFoundException{
			return properties.getProperty("pathVueloStream");
		}
		
		public String obtenerpathProvinciaStream() throws IOException, FileNotFoundException{
			return properties.getProperty("pathProvinciaStream");
		}
		
		
		public static String getSqlPath()
		{
			return properties.getProperty("sqlUrl");
		}
		
		public static String getSqlUser()
		{
			return properties.getProperty("sqlUser");
		}
		
		public static String getSqlPwd()
		{
			return properties.getProperty("sqlPwd");
		}
		public static String getSqlDriver()
		{
			return properties.getProperty("sqlDriver");
		}

	}

	


	