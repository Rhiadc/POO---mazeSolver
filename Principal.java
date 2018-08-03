import java.util.Scanner;

public class Principal{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		

		int num1 = -1;
		String regex = "[0-9]+";
		while(num1 != 0 && num1 != 1 && num1 != 2 && num1 != 3 && num1 != 4){
			System.out.print("Entrada para o labirinto (digite um valor de 0 a 4): ");
			try {
			    num1 = sc.nextInt();
			}
			catch (Exception e) {
			  System.out.println("Erro: numero invalido, mostrando mapa 1");
			  num1 = 0;
			  break;
			}
		}
		long inicio = System.currentTimeMillis(); 
		
		Maze labirinto = new Maze(num1);
		Caminho parede = new Parede();
		Caminho livre = new Livre();
		Caminho entrada = new Entrada();
		Caminho saida = new Saida();
		Caminho asterisco = new Asterisco();

		

		Object[][] objeto = new Object[13][13];
		char[][] mapaConvertido = new char[13][13];
		mapaConvertido = labirinto.soluciona();

		objeto = labirinto.criaMatrizCaminho(mapaConvertido, (Livre) livre, (Parede) parede, (Saida) saida, (Entrada) entrada);
		int coordenada = labirinto.getCoordenadaEntrada();

		MazeSolver mazeSolver = new MazeSolver(objeto, (Parede) parede, (Entrada) entrada, (Livre) livre, (Saida) saida, (Asterisco) asterisco);
		mazeSolver.mazeRecursive(coordenada, 1, -1);
		System.out.println("Mapa " + coordenada);
		mazeSolver.imprime();
		long fim  = System.currentTimeMillis();
		System.out.println("Tempo gasto: " +  (fim - inicio) + "ms");	
	}
}
