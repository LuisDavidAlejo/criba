
package com.mycompany.criba;
/**
* Clase para generar todos los numeros primos de 1 hasta
* un numero maximo especificado por el usuario. Como
* algoritmo se utiliza la criba de Eratostenes.
* <p>
* Eratostenes de Cirene (276 a.C., Cirene, Libia – 194
* a.C., Alejandria, Egipto) fue el primer hombre que
* calculo la circunferencia de la Tierra. Tambien
* se le conoce por su trabajo con calendarios que ya
* incluian anhos bisiestos y por dirigir la mitica
* biblioteca de Alejandria.
* <p>
* El algoritmo es bastante simple: Dado un vector de
* enteros empezando en 2, se tachan todos los multiplos
* de 2. A continuacion, se encuentra el siguiente
* entero no tachado y se tachan todos sus multiplos. El
* proceso se repite hasta que se pasa de la raiz cuadrada
* del valor maximo. Todos los numeros que queden sin
* tachar son numeros primos.
*
* @author Fernando Berzal
* @version 1.0 Enero’2005 (FB)
*/
public class Criba {
	/**
	* Generar numeros primos de 1 a max
	* @param max es el valor maximo
	* @return Vector de numeros primos
	*/
	public static int[] generarPrimos (int max) {
		int i,j;
		if (max >= 2) {
			// Declaraciones
			int dim = max + 1; // Tamanho del array
			boolean[] esPrimo = new boolean[dim];
			
			// Inicializar el array
			for (i=0; i<dim; i++)
				esPrimo[i] = true;
			
			// Eliminar el 0 y el 1, que no son primos
			esPrimo[0] = esPrimo[1] = false;
			
			// Criba
			for (i=2; i<Math.sqrt(dim)+1; i++) {
				if (esPrimo[i]) {
					// Eliminar los multiplos de i
					for (j=2*i; j<dim; j+=i)
					esPrimo[j] = false;
				}
			}
			
			// ¿Cuantos primos hay?
			int cuenta = 0;
			for (i=0; i<dim; i++) {
				if (esPrimo[i])
				cuenta++;
			}
			
			// Rellenar el vector de numeros primos
			int[] primos = new int[cuenta];
			for (i=0, j=0; i<dim; i++) {
				if (esPrimo[i])
				primos[j++] = i;
			}
			return primos;
		} else { // max < 2
			return new int[0]; // Vector vacio
		}
	}	
}
