package jogoDoOito;

import javax.swing.JOptionPane;

public class MontaJogo {

	public static String[][] matrizJogoFinal = new String[3][3];
	public static String[][] proximaJogada = new String[3][3];
	public static int numeroJogadas = 1;

	/**
	 * @param args
	 */
	public static void jogoInicial() {
		numeroJogadas = 1;

		Janela.instrucaoDoJogo.setText("Troque os números de \n"
				+ "ordem e depois clique em \n" + "resolver");

		Janela.resolvendo = false;

		Janela.botao[0][0].setText("1");
		Janela.botao[0][0].setEnabled(true);
		Janela.botao[0][0].setVisible(true);
		Janela.botao[0][1].setText("2");
		Janela.botao[0][1].setEnabled(true);
		Janela.botao[0][1].setVisible(true);
		Janela.botao[0][2].setText("3");
		Janela.botao[0][2].setEnabled(true);
		Janela.botao[0][2].setVisible(true);
		Janela.botao[1][0].setText("8");
		Janela.botao[1][0].setEnabled(true);
		Janela.botao[1][0].setVisible(true);
		Janela.botao[1][1].setText("0");
		Janela.botao[1][1].setEnabled(false);
		Janela.botao[1][1].setVisible(false);
		Janela.botao[1][2].setText("4");
		Janela.botao[1][2].setEnabled(true);
		Janela.botao[1][2].setVisible(true);
		Janela.botao[2][0].setText("7");
		Janela.botao[2][0].setEnabled(true);
		Janela.botao[2][0].setVisible(true);
		Janela.botao[2][1].setText("6");
		Janela.botao[2][1].setEnabled(true);
		Janela.botao[2][1].setVisible(true);
		Janela.botao[2][2].setText("5");
		Janela.botao[2][2].setEnabled(true);
		Janela.botao[2][2].setVisible(true);

		// / Seta resultado a chegar
		matrizJogoFinal[0][0] = "1";
		matrizJogoFinal[0][1] = "2";
		matrizJogoFinal[0][2] = "3";
		matrizJogoFinal[1][0] = "8";
		matrizJogoFinal[1][1] = "0";
		matrizJogoFinal[1][2] = "4";
		matrizJogoFinal[2][0] = "7";
		matrizJogoFinal[2][1] = "6";
		matrizJogoFinal[2][2] = "5";

	}

	public static void moveVazioClick(int linha, int coluna) {
		boolean flag = false;
		try {
			if (linha - 1 != -1) {
				if (Janela.botao[linha - 1][coluna].getText().equals("0")) {
					Janela.botao[linha - 1][coluna]
							.setText(Janela.botao[linha][coluna].getText());
					Janela.botao[linha - 1][coluna].setEnabled(true);
					Janela.botao[linha - 1][coluna].setVisible(true);
					Janela.botao[linha][coluna].setText("0");
					Janela.botao[linha][coluna].setEnabled(false);
					Janela.botao[linha][coluna].setVisible(false);
					numeroJogadas++;
					if (Janela.resolvendo == true) {
						Janela.instrucaoDoJogo.setText("Numero de Jogadas: "
								+ numeroJogadas + "\n");
					}
					flag = true;
				}
			}
			if (linha + 1 != 3) {
				if (Janela.botao[linha + 1][coluna].getText().equals("0")) {
					Janela.botao[linha + 1][coluna]
							.setText(Janela.botao[linha][coluna].getText());
					Janela.botao[linha + 1][coluna].setEnabled(true);
					Janela.botao[linha + 1][coluna].setVisible(true);
					Janela.botao[linha][coluna].setText("0");
					Janela.botao[linha][coluna].setEnabled(false);
					Janela.botao[linha][coluna].setVisible(false);
					numeroJogadas++;
					if (Janela.resolvendo == true) {
						Janela.instrucaoDoJogo.setText("Numero de Jogadas: "
								+ numeroJogadas + "\n");
					}
					flag = true;
				}
			}
			if (coluna - 1 != -1) {
				if (Janela.botao[linha][coluna - 1].getText().equals("0")) {
					Janela.botao[linha][coluna - 1]
							.setText(Janela.botao[linha][coluna].getText());
					Janela.botao[linha][coluna - 1].setEnabled(true);
					Janela.botao[linha][coluna - 1].setVisible(true);
					Janela.botao[linha][coluna].setText("0");
					Janela.botao[linha][coluna].setEnabled(false);
					Janela.botao[linha][coluna].setVisible(false);
					numeroJogadas++;
					if (Janela.resolvendo == true) {
						Janela.instrucaoDoJogo.setText("Numero de Jogadas: "
								+ numeroJogadas + "\n");
					}
					flag = true;
				}
			}
			if (coluna + 1 != 3) {
				if (Janela.botao[linha][coluna + 1].getText().equals("0")) {
					Janela.botao[linha][coluna + 1]
							.setText(Janela.botao[linha][coluna].getText());
					Janela.botao[linha][coluna + 1].setEnabled(true);
					Janela.botao[linha][coluna + 1].setVisible(true);
					Janela.botao[linha][coluna].setText("0");
					Janela.botao[linha][coluna].setEnabled(false);
					Janela.botao[linha][coluna].setVisible(false);
					numeroJogadas++;
					if (Janela.resolvendo == true) {
						Janela.instrucaoDoJogo.setText("Numero de Jogadas: "
								+ numeroJogadas + "\n");
					}
					flag = true;
				}

			}
			if (flag == false) {
				JOptionPane.showMessageDialog(null,
						"Esta peça não pode ser movimentada", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro inesperado", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void resolveJogo() {

		// /Analisa Jogada a frente
		int linhaVazio = Integer.parseInt(qualBotaoEhVazio().substring(0, 1));
		int colunaVazio = Integer.parseInt(qualBotaoEhVazio().substring(2, 3));

		Janela.instrucaoDoJogo.setText("Menor Jogada \n " +
				"Clique em um destes números: \n" +
				""+verificaMenorJogada(linhaVazio, colunaVazio));
	}

	public static String verificaMenorJogada(int linha, int coluna) {
		int pecasForaA = 99;
		String pecaA= "";
		int pecasForaB = 99;
		String pecaB= "";
		int pecasForaC = 99;
		String pecaC= "";
		int pecasForaD = 99;
		String pecaD= "";
		int menor = 99;
		String menorNome = "";
	
		proximaJogada[0][0] = Janela.botao[0][0].getText();
		proximaJogada[0][1] = Janela.botao[0][1].getText();
		proximaJogada[0][2] = Janela.botao[0][2].getText();
		proximaJogada[1][0] = Janela.botao[1][0].getText();
		proximaJogada[1][1] = Janela.botao[1][1].getText();
		proximaJogada[1][2] = Janela.botao[1][2].getText();
		proximaJogada[2][0] = Janela.botao[2][0].getText();
		proximaJogada[2][1] = Janela.botao[2][1].getText();
		proximaJogada[2][2] = Janela.botao[2][2].getText();
		                                        
		if (linha - 1 != -1) {
			pecasForaA = 0;
			proximaJogada[linha][coluna]=Janela.botao[linha-1][coluna].getText();
			proximaJogada[linha-1][coluna]="0";
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (!proximaJogada[i][j].equals(matrizJogoFinal[i][j])) {
						pecasForaA++;
						
					}
				}
			}
			pecaA = Janela.botao[linha-1][coluna].getText();
		}
		if (linha + 1 != 3) {
			pecasForaB = 0;
			proximaJogada[linha][coluna]=Janela.botao[linha+1][coluna].getText();
			proximaJogada[linha+1][coluna]="0";
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (!proximaJogada[i][j].equals(matrizJogoFinal[i][j])) {
						pecasForaB++;
						
					}
				}
			}
			pecaB = Janela.botao[linha+1][coluna].getText();
		}
		if (coluna - 1 != -1) {
			pecasForaC = 0;
			proximaJogada[linha][coluna]=Janela.botao[linha][coluna-1].getText();
			proximaJogada[linha][coluna-1]="0";
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (!proximaJogada[i][j].equals(matrizJogoFinal[i][j])) {
						pecasForaC++;
						
					}
				}
			}
			pecaC = Janela.botao[linha][coluna-1].getText();
		}
		if (coluna + 1 != 3) {
			pecasForaD = 0;
			proximaJogada[linha][coluna]=Janela.botao[linha][coluna+1].getText();
			proximaJogada[linha][coluna+1]="0";
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (!proximaJogada[i][j].equals(matrizJogoFinal[i][j])) {
						pecasForaD++;
					}
				}
			}
			pecaD = Janela.botao[linha][coluna+1].getText();
		}
		if (pecasForaA<pecasForaB && menor>pecasForaA){
			menorNome = pecaA;
			menor = pecasForaA;
			System.out.println("1 A"+pecasForaA+"B"+pecasForaB+"C"+pecasForaC+"D"+pecasForaD);
		}
		if (pecasForaB<pecasForaC && menor>pecasForaB){
			menorNome = pecaB;
			menor = pecasForaB;
			System.out.println("2 A"+pecasForaA+"B"+pecasForaB+"C"+pecasForaC+"D"+pecasForaD);
		}
		if (pecasForaC<pecasForaD && menor>pecasForaC){
			menorNome = pecaC;
			menor = pecasForaC;
			System.out.println("3 A"+pecasForaA+"B"+pecasForaB+"C"+pecasForaC+"D"+pecasForaD);
		}
		if (pecasForaD<pecasForaA && menor>pecasForaD){
			menorNome = pecaD;
			menor = pecasForaD;
			System.out.println("4 A"+pecasForaA+"B"+pecasForaB+"C"+pecasForaC+"D"+pecasForaD);
		}
		
		if (pecasForaA==pecasForaB && (pecasForaA<pecasForaC || pecasForaA<pecasForaD) && menor>=pecasForaA){
			menorNome = pecaA+","+pecaB;
			menor = pecasForaA;
			System.out.println("1 A"+pecasForaA+"B"+pecasForaB+"C"+pecasForaC+"D"+pecasForaD);
		}
		
		if (pecasForaB==pecasForaC && (pecasForaB<pecasForaA || pecasForaB<pecasForaD) && menor>=pecasForaB){
			menorNome = pecaB+","+pecaC;
			menor = pecasForaB;
			System.out.println("2 A"+pecasForaA+"B"+pecasForaB+"C"+pecasForaC+"D"+pecasForaD);
		}
		if ((pecasForaC==pecasForaD && (pecasForaC<pecasForaB || pecasForaC<pecasForaA)) && menor>=pecasForaC){
			menorNome = pecaC+","+pecaD;
			menor = pecasForaC;
			System.out.println("3 A"+pecasForaA+"B"+pecasForaB+"C"+pecasForaC+"D"+pecasForaD);
		}
		
		if (pecasForaD==pecasForaA && (pecasForaD<pecasForaC || pecasForaD<pecasForaB) && menor>=pecasForaD){
			menorNome = pecaD+","+pecaA;
			menor = pecasForaD;
			System.out.println("4 A"+pecasForaA+"B"+pecasForaB+"C"+pecasForaC+"D"+pecasForaD);
		}
		
		if (pecasForaB==pecasForaD && (pecasForaD<pecasForaC || pecasForaD<pecasForaA) && menor>=pecasForaD){
			menorNome = pecaD+","+pecaB;
			menor = pecasForaD;
			System.out.println("6 A"+pecasForaA+"B"+pecasForaB+"C"+pecasForaC+"D"+pecasForaD);
		}
		
		if (pecasForaA==pecasForaC && (pecasForaC<pecasForaD || pecasForaC<pecasForaB) && menor>=pecasForaC){
			menorNome = pecaC+","+pecaA;
			menor = pecasForaA;
			System.out.println("7 A"+pecasForaA+"B"+pecasForaB+"C"+pecasForaC+"D"+pecasForaD);
		}
		
		if((pecasForaD==pecasForaA)&&(pecasForaB==pecasForaC)&&(pecasForaB==pecasForaA)) {
			menorNome = pecaA+", "+pecaB+", "+pecaC+", "+pecaD;
			menor = pecasForaD;
			System.out.println("5 A"+pecasForaA+"B"+pecasForaB+"C"+pecasForaC+"D"+pecasForaD);
		}
		
		return menorNome;
	}
	
	
	private static String qualBotaoEhVazio() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (Janela.botao[i][j].getText().equals("0")) {
					return i + "," + j;
				}
			}
		}
		return "erro"; // erro
	}

	public static int verificaFimDeJogo() {
		// TODO Auto-generated method stub
		int cont = 0;
		if (Janela.resolvendo == true) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (Janela.botao[i][j].getText().equals(
							matrizJogoFinal[i][j])) {
						cont++;
					}
				}
			}
			if (cont == 9) {

				Janela.botao[0][0].setEnabled(false);
				Janela.botao[0][1].setEnabled(false);
				Janela.botao[0][2].setEnabled(false);
				Janela.botao[1][0].setEnabled(false);
				Janela.botao[1][1].setEnabled(false);
				Janela.botao[1][2].setEnabled(false);
				Janela.botao[2][0].setEnabled(false);
				Janela.botao[2][1].setEnabled(false);
				Janela.botao[2][2].setEnabled(false);

				JOptionPane.showMessageDialog(null, "Jogo Finalizado",
						"Parabéns", JOptionPane.INFORMATION_MESSAGE);
				return 1;
			}
		}
		return 0;
	}
}
