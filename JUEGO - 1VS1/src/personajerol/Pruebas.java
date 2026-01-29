package personajerol;

import personajerol.exceptions.*;

public class Pruebas {

	public static void main(String[] args) throws InterruptedException {

		Personaje protagonista = null;
		Personaje enemigo = null;

		try {
			protagonista = new Personaje("DonPrueba", 20, 5, 7);
			enemigo = new Personaje("DonEnemigoPrueba", 20, 5, 7);
		} catch (VidaNoValidaException vidaEx) {
			System.out.println(vidaEx.getMessage());
		} catch (AgilidadNoValidaException agilidadEx) {
			System.out.println(agilidadEx.getMessage());
		} catch (FuerzaNoValidaException fuerzaEx) {
			System.out.println(fuerzaEx.getMessage());
		}

		// Informacion protagonista
		System.out.println("Info protagonista:");
		System.out.println("Nombre: " + protagonista.getNombre());
		System.out.println();
		protagonista.mostrarCaracteristicas();
		System.out.println();

		// Informacion enemigo
		System.out.println("Info enemigo:");
		System.out.println("Nombre: " + enemigo.getNombre());
		System.out.println();
		enemigo.mostrarCaracteristicas();
		System.out.println();

		// Protagonista ataca a enemigo
		System.out.print("Realizando ataque a enemigo.");
		Thread.sleep(800);
		System.out.print(".");
		Thread.sleep(800);
		System.out.println(".");
		Thread.sleep(800);
		enemigo.recibirGolpe(protagonista.hacerAtaque());
		System.out.println("Vida restante de enemigo: " + enemigo.vidaRestante());
		System.out.println();

		// Enemigo ataca a protagonista
		System.out.print("El enemigo te está atacando.");
		Thread.sleep(800);
		System.out.print(".");
		Thread.sleep(800);
		System.out.println(".");
		Thread.sleep(800);
		protagonista.recibirGolpe(enemigo.hacerAtaque());
		System.out.println("Vida restante del protagonista: " + protagonista.vidaRestante());
		System.out.println();

	}

}
