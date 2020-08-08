package mvc.modelo.dominio;

public enum FormaDePago {
	
		CONTADO_EFECTIVO("Contado efectivo"),
		TARJETA_DEBITO("Tarjeta de D�bito"),
		TARJETA_CREDITO("Tarjeta de Cr�dito");
			
		public final String value;
		
		private FormaDePago(String value) {
			this.value = value;
		}
		
		public static FormaDePago get (String nombre) {
			if(nombre.equals("Contado efectivo")) {
				return CONTADO_EFECTIVO;
			}
			if(nombre.equals("Tarjeta de D�bito")) {
				return TARJETA_DEBITO;
			}
			if(nombre.equals("Tarjeta de Cr�dito")) {
				return TARJETA_CREDITO;
			}
			return null;
		}

	}



