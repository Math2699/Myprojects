/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoracmd;
import calculadora.Calculadora;

/**
 *
 * @author jromo
 */
public class CalculadoraCmd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Calculadora Cal1 = new Calculadora();

	System.out.println("Hola Soy la Calculadora de Mateo");

	try {
		// Aqui va el codigo que puede lanzar una excepcion
		// Asignacion de Parametros de Linea de comandos.
		System.out.println("El resultado es: "+Cal1.Calcular(Float.parseFloat(args[0]),args[1],Float.parseFloat(args[2])));		
	} catch (NumberFormatException e) {
		System.out.println("Numero de Argumentos o valores Invalidos. Ej. 2 + 3 "); 	
		 //   System.out.println ("El error es: "+op + e.getMessage());
		 //   e.printStackTrace();
	}
		// Realiza operacion en base parametro
		// System.out.println("El resultado es : " + Cal1.Resultado());   		
  }
       // TODO code application logic here
    }
    

