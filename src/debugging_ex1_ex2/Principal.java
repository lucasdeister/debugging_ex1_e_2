package debugging_ex1_ex2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		Log lg = new Log("Log.txt");
		try {
			lg.logger.setLevel(Level.FINE);
			lg.logger.info("Log de informação");
			lg.logger.warning("Log de aviso");
			lg.logger.severe("Log severo");
		}
		catch(Exception e){
			lg.logger.info("Exception:" + e.getMessage());
			e.printStackTrace();
		}
		
		lg.logger.info("\n O programa iniciou a calculadora");
		
		try (Scanner leitura = new Scanner(System.in)) {
			Calculadora c = new Calculadora();
			float a = 0, b = 0, resultado = 0;
			String operador;
			System.out.println("Calculadora");
			do {
				System.out.println("Insira o operador +, -, *, /");
				operador = leitura.nextLine();
			} while (!(operador.contains("+") || operador.contains("-") || operador.contains("*")
					|| operador.contains("/")));

			System.out.println("Insira o 1o valor");
			a = leitura.nextFloat();
			System.out.println("Insira o 2o valor");
			b = leitura.nextFloat();

			resultado = c.calcular(a, b, operador.charAt(0));
			System.out.println("O resultado de " + a + " " + operador + " " + b + " é:" + resultado);
			
			
			lg.logger.info("\n O programa terminou a operação da calculadora." + " O resultado é = " + resultado);
		}

	}

}
