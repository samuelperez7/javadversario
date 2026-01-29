package javadversario;

import java.io.*;

import javadversario.exceptions.*;

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
			System.out.println("       **********************");
			System.out.println("       * ELIGE TU PERSONAJE *");
			System.out.println("       **********************");
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

		Personaje protagonista = null;

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
		}

		// Creacion de enemigo
		Personaje personaje4 = null;
		Personaje personaje5 = null;
		Personaje personaje6 = null;

		try {
			personaje4 = new Personaje("Evil Juan", 20, 3, 7);
			personaje5 = new Personaje("Evil Alicia", 20, 5, 5);
			personaje6 = new Personaje("Evil Antonio", 20, 3, 6);
		} catch (VidaNoValidaException vidaEx) {
			System.out.println(vidaEx.getMessage());
		} catch (AgilidadNoValidaException agilidadEx) {
			System.out.println(agilidadEx.getMessage());
		} catch (FuerzaNoValidaException fuerzaEx) {
			System.out.println(fuerzaEx.getMessage());
		}
		
		Personaje enemigo = null;
		int enemigoElegido = (int) (Math.random()*3);
		
		switch (enemigoElegido) {
		case 0:
			enemigo = personaje4;
			break;
		case 1:
			enemigo = personaje5;
			break;
		case 2:
			enemigo = personaje6;
			break;
		}

		// Inicio del juego
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println("       🢂INFORMACIÓN DEL JUEGO🢀");
		System.out.println("       ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
		System.out.println();
		System.out.println();
		Thread.sleep(1500);
		System.out.println("     🡻PROTAGONISTA (TU PERSONAJE)🡻");
		System.out.println();
		protagonista.mostrarCaracteristicas();
		System.out.println();
		System.out.println();
		Thread.sleep(4000);
		System.out.println("       🡻ENEMIGO (TU ADVERSARIO)🡻");
		System.out.println();
		enemigo.mostrarCaracteristicas();
		Thread.sleep(5000);

		// "Pantalla de carga"
		for (int i = 0; i < 50; i++) {
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
		System.out.println();

		// Empieza la pelea
		boolean turnoGolpear = (int) (Math.random() * 2) == 1 ? true : false;
		do {
			Thread.sleep(2400);
			if (turnoGolpear == true) {
				enemigo.recibirGolpe(protagonista.hacerAtaque());
				System.out.println("Has golpeado a "+enemigo.getNombre()+"!!");
				if (enemigo.vidaRestante() > 0) {
					System.out.println("Tu vida restante: " + Math.round((double)protagonista.vidaRestante()/20*100)+"%");
					System.out.println("Vida de "+enemigo.getNombre()+": "+Math.round((double)enemigo.vidaRestante()/20*100)+"%");
				} else {
					System.out.println();
					System.out.println("🎉 ENHORABUENA! | HAS DERROTADO AL ENEMIGO 🎉");
				}
			} else {
				protagonista.recibirGolpe(enemigo.hacerAtaque());
				
				System.out.println(enemigo.getNombre()+" te ha golpeado!!");
				if (protagonista.vidaRestante() > 0) {
					System.out.println("Tu vida restante: " + Math.round((double)protagonista.vidaRestante()/20*100)+"%");
					System.out.println("Vida de "+enemigo.getNombre()+": "+Math.round((double)enemigo.vidaRestante()/20*100)+"%");
				} else {
					System.out.println();
					System.out.println("☠ GAME OVER | HAS MUERTO ☠");
				}
			}
			System.out.println();
			System.out.println();
			turnoGolpear = !turnoGolpear;
		} while (protagonista.vidaRestante() > 0 && enemigo.vidaRestante() > 0);

	}

}
