package jogoDoOito;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Jogodavelha extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JButton[][] botoes;
    private String vez;
    private boolean terminou;
    private static final Color COR_X = Color.RED;
    private static final Color COR_O = Color.BLUE;

    public Jogodavelha() throws HeadlessException {
        super("Jogo da Velha");

        setSize(200, 240);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Jogo");
        JMenuItem itemNovo = new JMenuItem("Novo Jogo");
        itemNovo.addActionListener(this);
        menu.add(itemNovo);
        menu.addSeparator();
        JMenuItem iteSair = new JMenuItem("Sair");
        iteSair.addActionListener(this);
        menu.add(iteSair);
        menuBar.add(menu);
        setJMenuBar(menuBar);
      
        criarNovoJogo();

        centralizarJanela();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
        addWindowListener(new WindowAdapter() {
            public final void windowClosing(final WindowEvent e) {
                    System.exit(0);
            }
        });
    }

    private void criarNovoJogo() {
        getContentPane().removeAll();
        int borda = 25;
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(Box.createVerticalStrut(borda), BorderLayout.NORTH);
        getContentPane().add(Box.createVerticalStrut(borda), BorderLayout.SOUTH);
        getContentPane().add(Box.createHorizontalStrut(borda), BorderLayout.EAST);
        getContentPane().add(Box.createHorizontalStrut(borda), BorderLayout.WEST);
        JPanel pJogo = new JPanel();
        pJogo.setLayout(new GridLayout(3, 3));
        
        botoes = new JButton[3][3];
        Font font = new Font("Verdana", Font.BOLD, 14);
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                botoes[x][y] = new JButton();
                botoes[x][y].setActionCommand("b" + x + "_" + y);
                botoes[x][y].addActionListener(this);
                botoes[x][y].setFont(font);
                pJogo.add(botoes[x][y]);
            }
        }
        getContentPane().add(pJogo, BorderLayout.CENTER);
        getContentPane().validate();

        vez = "Jogador";
        terminou = false;
    }

    public void actionPerformed(ActionEvent arg0) {

    	if ("Novo Jogo".equals(arg0.getActionCommand())) {
            criarNovoJogo();
        } else if (arg0.getActionCommand().startsWith("b")) {
            if (terminou) {
                JOptionPane.showMessageDialog(null, "Jogo finalizado!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                String[] coord = arg0.getActionCommand().substring(1).split("_");
                int x = Integer.parseInt(coord[0]);
                int y = Integer.parseInt(coord[1]);
                if (botoes[x][y].getText().equals("")) {
                    botoes[x][y].setText(vez);
                    if (vez.equals("X")) {
                        botoes[x][y].setForeground(COR_X);                        
                        vez = "O";
                    } else {
                        botoes[x][y].setForeground(COR_O);                        
                        vez = "X";
                    }
                    verificarVitoria();
                } else {
                    JOptionPane.showMessageDialog(null, "Posição já foi marcada!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void verificarVitoria() {
        String vencedor = "";
        // Verifica horizontais e verticais
        for (int i = 0; i < 3; i++) {
            if (!botoes[i][0].getText().equals("")) {
                if ((botoes[i][0].getText().equals(botoes[i][1].getText())) && (botoes[i][2].getText().equals(botoes[i][1].getText()))) {
                    terminou = true;
                    vencedor = botoes[i][0].getText();
                    break;
                }
            }
            if (!botoes[0][i].getText().equals("")) {
                if ((botoes[0][i].getText().equals(botoes[1][i].getText())) && (botoes[2][i].getText().equals(botoes[1][i].getText()))) {
                    terminou = true;
                    vencedor = botoes[0][i].getText();
                    break;
                }
            }
        }
        // Verifica diagonais
        if (!botoes[1][1].getText().equals("")) {
            if ((botoes[0][0].getText().equals(botoes[1][1].getText())) && (botoes[2][2].getText().equals(botoes[1][1].getText()))) {
                terminou = true;
                vencedor = botoes[1][1].getText();
            } else if ((botoes[0][2].getText().equals(botoes[1][1].getText())) && (botoes[2][0].getText().equals(botoes[1][1].getText()))) {
                terminou = true;
                vencedor = botoes[1][1].getText();
            }
        }
        if (terminou) {
            JOptionPane.showMessageDialog(null, vencedor + " é o vencedor!", "Vitória", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public final void centralizarJanela() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        int x = ge.getCenterPoint().x - (this.getWidth() / 2);
        int y = ge.getCenterPoint().y - (this.getHeight() / 2);
        setLocation(x, y);
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        Jogodavelha jogo = new Jogodavelha();
        jogo.setVisible(true);
    }
}
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Teste frame = new Teste();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public Teste() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//	}

//}
