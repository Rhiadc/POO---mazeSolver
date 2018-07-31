public class Principal{
	public static void main(String[] args){
		Maze labirinto = new Maze(0);
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
	}
}
