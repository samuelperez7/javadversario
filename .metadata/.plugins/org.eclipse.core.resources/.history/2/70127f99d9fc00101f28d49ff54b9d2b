package personajerol;

import java.io.*;

import personajerol.exceptions.*;

public class Juego {

	public static void main(String[] args) throws IOException, InterruptedException {
		InputStreamReader flujo = new InputStreamReader(System.in);
		BufferedReader lector = new BufferedReader(flujo);

		// Creacion de personajes

		Personaje personaje1 = null;
		Personaje personaje2 = null;
		Personaje personaje3 = null;

		try {
			personaje1 = new Personaje("David", 20, 3, 5);
			personaje2 = new Personaje("Agustin", 20, 4, 6);
			personaje3 = new Personaje("Sergio", 20, 4, 7);
		} catch (VidaNoValidaException vidaEx) {
			System.out.println(vidaEx.getMessage());
		} catch (AgilidadNoValidaException agilidadEx) {
			System.out.println(agilidadEx.getMessage());
		} catch (FuerzaNoValidaException fuerzaEx) {
			System.out.println(fuerzaEx.getMessage());
		}

		// Introduccion al juego
		System.out.println("   *******************************");
		System.out.println("   *        JAVADVERSARIO        *");
		System.out.println("   *******************************");
		System.out.println();

		// Elección de personaje

		String personajeElegidoS = "0";
		int personajeElegido;

		do {
			System.out.println("      **********************");
			System.out.println("      * ELIGE TU PERSONAJE *");
			System.out.println("      **********************");
			System.out.println();
			personaje1.mostrarCaracteristicas();
			System.out.println();
			personaje2.mostrarCaracteristicas();
			System.out.println();
			personaje3.mostrarCaracteristicas();
			System.out.println();
			System.out.println("    1. David");
			System.out.println("    2. Agustin");
			System.out.println("    3. Sergio");
			System.out.println();
			System.out.print("    ¿Cual eliges? ");
			personajeElegidoS = lector.readLine();
			personajeElegido = Integer.parseInt(personajeElegidoS);
		} while (personajeElegido != 1 && personajeElegido != 2 && personajeElegido != 3);

		// Creación de protagonista

		Personaje protagonista;

		switch (personajeElegido) {
		case 1:
			protagonista = personaje1;
			break;
		case 2:
			protagonista = personaje2;
			break;
		case 3:
			protagonista = personaje3;
			break;
		default:
			protagonista = personaje1;
		}

		// Creacion de enemigo
		Personaje enemigo = null;

		try {
			enemigo = new Personaje("Devil Juan", (int) Math.random() * 4 + 16, (int) Math.random() * 2 + 3,
					(int) Math.random() * 2 + 5);
		} catch (VidaNoValidaException vidaEx) {
			System.out.println(vidaEx.getMessage());
		} catch (AgilidadNoValidaException agilidadEx) {
			System.out.println(agilidadEx.getMessage());
		} catch (FuerzaNoValidaException fuerzaEx) {
			System.out.println(fuerzaEx.getMessage());
		}

		// Inicio del juego
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
		System.out.println("       🢂INFORMACIÓN DEL JUEGO🢀");
		System.out.println("       ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
		System.out.println();
		Thread.sleep(1500);
		System.out.println("     🡻PROTAGONISTA (TU PERSONAJE)🡻");
		System.out.println();
		protagonista.mostrarCaracteristicas();
		System.out.println();
		Thread.sleep(4000);
		System.out.println("       🡻ENEMIGO (TU ADVERSARIO)🡻");
		System.out.println();
		enemigo.mostrarCaracteristicas();
		Thread.sleep(5000);

		// "Pantalla de carga"
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
		System.out.println();
		System.out.print("          EMPEZANDO JUEGO");
		System.out.print(".");
		Thread.sleep(800);
		System.out.print(".");
		Thread.sleep(800);
		System.out.print(".");
		Thread.sleep(800);
		System.out.println();

		// Empieza la pelea
		boolean turnoGolpear = (int) (Math.random() * 2) == 1 ? true : false;
		do {
			Thread.sleep(2000);
			if (turnoGolpear == true) {
				enemigo.recibirGolpe(protagonista.hacerAtaque());
				System.out.println("Has golpeado a "+enemigo.getNombre()+"!!");
					System.out.println("Vida restante: " + protagonista.vidaRestante());
				if (enemigo.vidaRestante()<=0) {
					System.out.println();
					System.out.println("ENHORABUENA! | HAS DERROTADO AL ENEMIGO");
				}
			} else {
				protagonista.recibirGolpe(enemigo.hacerAtaque());
				System.out.println(enemigo.getNombre()+" te ha golpeado!!");
				if (protagonista.vidaRestante() > 0) {
					System.out.println("Vida restante: " + protagonista.vidaRestante());
				} else {
					System.out.println();
					System.out.println("GAME OVER | HAS MUERTO");
				}
			}
			System.out.println();
			turnoGolpear = !turnoGolpear;
		} while (protagonista.vidaRestante() > 0 && enemigo.vidaRestante() > 0);

	}

}
