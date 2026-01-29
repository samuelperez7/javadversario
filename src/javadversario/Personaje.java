package javadversario;

import javadversario.exceptions.*;

public class Personaje {
	
	// Atributos
	private String nombre;
	private int vida;
	private int agilidad;
	private int fuerza;
	
	// Constructores
	public Personaje(String nombre,int fuerza) {
		this.nombre = nombre;
		this.fuerza = fuerza;
		vida = 20;
		agilidad = 3;
	}

	public Personaje(String nombre, int vida, int agilidad, int fuerza) throws VidaNoValidaException,AgilidadNoValidaException,FuerzaNoValidaException {
		if (vida<1 || vida>20) {
			VidaNoValidaException vidaEx = new VidaNoValidaException();
			throw vidaEx;
		} else if (agilidad<0 || agilidad>5) {
			AgilidadNoValidaException agilidadEx = new AgilidadNoValidaException();
			throw agilidadEx;
		} else if (fuerza<0 || fuerza>7) {
			FuerzaNoValidaException fuerzaEx = new FuerzaNoValidaException();
			throw fuerzaEx;
		} else {
			this.nombre = nombre;
			this.vida = vida;
			this.agilidad = agilidad;
			this.fuerza = fuerza;
		}
	}
	
	// Otros métodos
	public String getNombre() {
		return nombre;
	}
	
	public int vidaRestante() {
		return vida;
	}
	
	public void mostrarCaracteristicas() {
		System.out.println("   ********************************");
		System.out.println();
		System.out.println("    CARACTERÍSTICAS DEL PERSONAJE");
		System.out.println("    Nombre: "+nombre);
		System.out.println("    Vida: "+vida);
		System.out.println("    Agilidad: "+agilidad);
		System.out.println("    Fuerza: "+fuerza);
		System.out.println();
		System.out.println("   ********************************");
	}
	
	public int hacerAtaque() {
		int dañoProducido;
		
		dañoProducido = (int) (Math.random()*fuerza+1);
		
		return dañoProducido;
	}
	
	public void recibirGolpe(int golpe) {
		int dañoRecibido;
		
		dañoRecibido = golpe-((int)(Math.random()*agilidad+1));
		
		if (dañoRecibido<0) {
			dañoRecibido=0;
		}
		
		this.vida = this.vida - dañoRecibido;
	}
	
	
	
}
