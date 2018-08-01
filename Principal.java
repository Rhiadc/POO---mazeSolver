import java.util.Scanner;
public class Principal{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrada para o labirinto (digite um valor de 0 a 4): ");
		int num1 = sc.nextInt();
		while(num1 != 0 && num1 != 1 && num1 != 2 && num1 != 3 && num1 != 4){
			System.out.print("Erro, favor digite um valor de 0 a 4: ");
				num1 = sc.nextInt();
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
		mazeSolver.imprime();
		long fim  = System.currentTimeMillis();
		System.out.println("Tempo gasto: " +  (fim - inicio) + "ms");	
	}
}
