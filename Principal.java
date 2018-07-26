public class Principal{
	public static void main(String[] args){
		Maze labirinto = new Maze(0);
		Caminho parede = new Parede();
		Caminho livre = new Livre();
		Caminho entrada = new Entrada();
		Caminho saida = new Saida();
		Caminho asterisco = new Asterisco();

		labirinto.soluciona();

		Object[][] objeto = new Object[13][13];
		objeto = labirinto.insere((Livre) livre, (Parede) parede, (Saida) saida, (Entrada) entrada);
		//labirinto.imprime();

		MazeSolver mazeSolver = new MazeSolver(objeto, (Parede) parede, (Entrada) entrada, (Livre) livre, (Saida) saida, (Asterisco) asterisco);
		mazeSolver.mazeRecursive(1, 1, -1);
		mazeSolver.imprime();	
		//labirinto.imprimeTeste();	
	}
}
