package redeNeural;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class Treinamento {

	public int pesos[] = new int[25];
	public int valorDeEntrada[] = new int[25];
	public int valorDeSaida;
	public int pesosAtual[] = new int[25];

	public void inicializarPesos() {
		System.out.println("");
		for (int i = 0; i < pesos.length; i++) {
			pesos[i] = 0;
			System.out.print(pesos[i] + ",");
		}
		System.out.println("");
	}

	public void inserirValorDeEntrada(String caminho) {
		try {
			FileReader fr = new FileReader(caminho);
			BufferedReader br = new BufferedReader(fr);
			try {
				String linha;
				int numeroLinha = -1;
				while ((linha = br.readLine()) != null) {
					numeroLinha++;
					for (int j = 0; j < linha.length(); j++) {
						int x = (numeroLinha * (linha.length())) + j;
						char caracter = linha.charAt(j);
						System.out.print(caracter);
						if (caracter == '#') {
							valorDeEntrada[x] = 1;
							System.out.print(valorDeEntrada[x] + "|");
						} else {
							valorDeEntrada[x] = -1;
							System.out.print(valorDeEntrada[x] + "|");
						}
					}
				}
				br.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (FileNotFoundException ne) {
			JOptionPane.showMessageDialog(null, "Caminho não encontrado");
		}
	}

	public void inserirValorDeSaida(char saida) {
		char valorSaidaInformado = 'x';
		if (valorSaidaInformado == 'x') {
			valorDeSaida = 1;
		} else {
			valorDeSaida = -1;
		}
	}

	public void ajustarPesos() {
		System.out.println("");
		for (int i = 0; i < pesos.length; i++) {
			pesosAtual[i] = pesos[i] + valorDeEntrada[i] * valorDeSaida;
			System.out.print(pesosAtual[i] + "|");
		}
	}
}
