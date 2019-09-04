/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author jromo
 */
public class Calculadora {

  double a=0; 
  String op ="";
  double b=0;
  double c=0;
	
	public void Calculadora () 
	{
	  a=0;
	  op ="";
	  b=0;
	  c=0;

	}
	 public void Calculadora (double pa, String pOp, double pb) 
	{
	 
	  this.Calcular( pa, pOp, pb); 
	}
    public double Resultado () 
	{
	  return c; 
	}
	public double Calcular (double pa, String pOp, double pb)
	{
          a=pa;
	  op = pOp;
	  b=pb;
		switch ( op ) {
      		case "+":
        	   c = a + b;
        	   break;
      		case "-":
        	   c= a - b;
        	   break;
      		case "x":
           	   c = a * b;
           	   break;
      		case "/":
           	   c = a / b;
           	   break;
      		case "^":
           	   c = Math.pow(a, b);
           	   break;
      		default:
           	   System.out.println("error "+op+" Operador no Soportado. Ej. Operadores soportados + - x / ^" );
		   c = 0;
           	   break;
		}
                return c;
	}
}
