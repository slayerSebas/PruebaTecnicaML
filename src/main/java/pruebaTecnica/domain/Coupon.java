package pruebaTecnica.domain;

/**
 * Clase que representa un cupón de descuento.
 * Un cupón tiene un nombre y un valor asociado que determina 
 * el porcentaje del descuento a aplicar.
 */
public class Coupon {
	private String name;
	private double value;

	 /**
     * Constructor de la clase Coupon que permite la creación de un cupón con un nombre y un valor.
     *
     * @param name  El nombre del cupón.
     * @param value El valor del descuento. (0-100).
     */
	public Coupon(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Metodo que permite obtener el nombre de un cupón.
	 * 
	 * @return El nombre de un cupón.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Metodo que permite actualizar el nombre de un cupón.
	 * 
	 * @param name El nombre del cupón.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo que permite obtener el valor de un cupón.
	 * 
	 * @return El valor de un cupón
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Metodo que permite actualizar el valor de un cupón.
	 * 
	 * @param value El valor del cupón.
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Metodo que permite validar cuando un cupon es valido o no.
	 * 
	 * @return Retorna verdadero si el cupon es valido o falso si no lo es.
	 */
	public boolean isValid() {
		if (name != null && !name.trim().isEmpty() && value > 0 && value <= 100) {
			return true;
		} else {
			return false;
		}
	}

}
