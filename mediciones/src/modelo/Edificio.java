package modelo;

public class Edificio {
	private double distanciaSombra;
	private double altura;
	private double angulo;
	
	public double getDistanciaSombra() {
		return distanciaSombra;
	}
	public void setDistanciaSombra (double distanciaSombra)throws ExcepcionDistanciaSombra{
		if(distanciaSombra>=0)
			this.distanciaSombra = distanciaSombra;
		else
			throw new ExcepcionDistanciaSombra("Error en distancia, no puede ser negativa");
	}
	public double getAltura() {
		return altura;
	}
	public void calcularAltura() {
			altura = distanciaSombra* Math.tan(angulo);
	}
	public double getAngulo() {
		return angulo;
	}
	public void setAngulo(double angulo) throws ExcepcionAngulo {
		if(angulo>=0 && angulo<90 ){
				angulo= Math.PI*angulo/180;
				this.angulo = angulo;
		
		}else
			throw new ExcepcionAngulo("Error en angulo, debe estar entre 0 y 90, sin ser 90");

	}
	

}
