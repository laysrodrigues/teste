package redeNeural;

public class RedesNeurais {

	public static void main(String[] args) {
		
		String caminho = "c:/Lays/Unisul/6semestre/InteligenciaArtificial/x.txt";
		char saida = 'x';
		
		Treinamento t = new Treinamento();
		t.inicializarPesos();
		t.inserirValorDeEntrada(caminho);
		t.inserirValorDeSaida(saida);
		t.ajustarPesos();

		caminho = "c:/Lays/Unisul/6semestre/InteligenciaArtificial/o.txt";
		saida = 'o';
		
		t.inicializarPesos();
		t.inserirValorDeEntrada(caminho);
		t.inserirValorDeSaida(saida);
		t.ajustarPesos();
		
		
	}
}
