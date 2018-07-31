import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Maze{

	private Parede parede;
	private Livre livre;
	private Saida saida;
	private Entrada entrada;
	public Object[][] objeto;
	private List<String> listaConversao; 
	private int arquivoMapa;
	private int coordenada;

	public Maze(int arquivoMapa){
		this.arquivoMapa = arquivoMapa;
		this.objeto = new Object[13][13];
	}

	//retorna o numero do mapa
	private int getArquivoMapa(){
		return this.arquivoMapa;
	}
	
	//inicia a conversão do mapa lido do txt, transforma em uma lista, e depois em uma matriz de caracteres.
	public char[][] soluciona(){
		char[][] mapaConvertido = new char[13][13];
		listaConversao = leArquivoMapa(getArquivoMapa());
		mapaConvertido = converteMapaChar(listaConversao);
		return mapaConvertido;

	}

	//Este metodo recebe como um parâmetro um valor de 0 a 4, lê o txt do mapa associado ao valor, cria uma lista de strings, e armazena cada
	//linha como uma unica string
	private List<String> leArquivoMapa(int value){
		String arquivo = "mapa" + value + ".txt";
		String linha;  
		File mapa = new File(arquivo);
		List<String> lista = new ArrayList<String>();
		try {
		  BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(mapa)));
		  while (br.ready()) {
		    linha = br.readLine();
		    lista.add(linha);
		  }
		  br.close(); 
		}
		catch (Exception e) {
		  System.out.println("Erro: " + e.getMessage());
		}
		return lista;
	}

	//Este método recebe a lista de strings, lida do txt de mapa, e a converte para uma matriz de char, ignorando os espaços adicionais (retirados da
	// posição impar)
	private char[][] converteMapaChar(List mapa){
	    char[][] mapaConvertido = new char[13][13];
		int cont = 0;
		for (int i = 0; i <mapa.size(); i++) {
			String s = (String) mapa.get(i);
			for(int j=0; j<s.length(); j++){
				if(j%2==0){
					mapaConvertido[i][cont] = s.charAt(j); 
					cont+=1;
				}
			}
			cont=0;								
		}
		return mapaConvertido;
	}

	//Este metodo recebe a matriz em char e cria uma nova matriz de objetos espaço/caminho/final 
	public Object[][] criaMatrizCaminho(char[][] mapaConvertido, Livre livre, Parede parede, Saida saida, Entrada entrada){
		for(int i=0; i<mapaConvertido.length; i++){
			for(int j=0; j<mapaConvertido[0].length; j++){
				if(mapaConvertido[i][j]== ' '){
					objeto[i][j] = (Livre) livre;
				}else if(mapaConvertido[i][j] == 'x'){
					objeto[i][j] = (Parede) parede;
				}else if(mapaConvertido[i][j] == 'f'){
					objeto[i][j] = (Saida) saida;
				}else{
                    objeto[i][j] = (Entrada) entrada;
                    setCoordenadaEntrada(i);   
                }
               
            }
        }
        return objeto;
    }

   

    private void setCoordenadaEntrada(int coordenada){
        this.coordenada = coordenada;
    }

    public int getCoordenadaEntrada(){
        return this.coordenada;
    }

}
