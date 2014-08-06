package jogoDoOito;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.custom.StyledText;

public class Janela extends Shell {
	public static Button[][] botao = new Button[3][3];
	public static boolean resolvendo;
	private MenuItem jogarNovamente;
	private MenuItem resolverJogo;
	public static StyledText instrucaoDoJogo;
	private int resultado;
	/**
	 * Launch the application.
	 * @param args
	 */
	
	public static void main(String args[]) {
		
		
		try {
			Display display = Display.getDefault();
			Janela shell = new Janela(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Janela(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		
		
		botao[0][0] = new Button(this, SWT.NONE);
		botao[0][0].setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		botao[0][0].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MontaJogo.moveVazioClick(0,0);
				resultado = MontaJogo.verificaFimDeJogo();
				if (resolvendo == true && resultado==0){
					MontaJogo.resolveJogo();
				}
			}

			
		});
		botao[0][0].setBounds(10, 10, 120, 75);
		
		botao[0][1] = new Button(this, SWT.NONE);
		botao[0][1].setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		botao[0][1].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MontaJogo.moveVazioClick(0,1);
				resultado = MontaJogo.verificaFimDeJogo();
				if (resolvendo == true && resultado==0){
					MontaJogo.resolveJogo();
				}
			}
		});
		botao[0][1].setBounds(150, 10, 120, 75);
		
		botao[0][2] = new Button(this, SWT.NONE);
		botao[0][2].setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		botao[0][2].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MontaJogo.moveVazioClick(0,2);
				resultado = MontaJogo.verificaFimDeJogo();
				if (resolvendo == true && resultado==0){
					MontaJogo.resolveJogo();
				}
			}
		});
		botao[0][2].setBounds(290, 10, 120, 75);
		
		botao[1][0] = new Button(this, SWT.NONE);
		botao[1][0].setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		botao[1][0].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MontaJogo.moveVazioClick(1,0);
				resultado = MontaJogo.verificaFimDeJogo();
				if (resolvendo == true && resultado==0){
					MontaJogo.resolveJogo();
				}
			}
		});
		botao[1][0].setBounds(10, 95, 120, 75);
		
		botao[1][1] = new Button(this, SWT.NONE);
		botao[1][1].setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		botao[1][1].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MontaJogo.moveVazioClick(1,1);
				resultado = MontaJogo.verificaFimDeJogo();
				if (resolvendo == true && resultado==0){
					MontaJogo.resolveJogo();
				}
			}
		});
		botao[1][1].setBounds(150, 95, 120, 75);
		
		
		botao[1][2] = new Button(this, SWT.NONE);
		botao[1][2].setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		botao[1][2].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MontaJogo.moveVazioClick(1,2);
				resultado = MontaJogo.verificaFimDeJogo();
				if (resolvendo == true && resultado==0){
					MontaJogo.resolveJogo();
				}
			}
		});
		botao[1][2].setBounds(290, 95, 120, 75);
		
		botao[2][0] = new Button(this, SWT.NONE);
		botao[2][0].setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		botao[2][0].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MontaJogo.moveVazioClick(2,0);
				resultado = MontaJogo.verificaFimDeJogo();
				if (resolvendo == true && resultado==0){
					MontaJogo.resolveJogo();
				}
			}
		});
		botao[2][0].setBounds(10, 180, 120, 75);
		
		botao[2][1]= new Button(this, SWT.NONE);
		botao[2][1].setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		botao[2][1].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MontaJogo.moveVazioClick(2,1);
				resultado = MontaJogo.verificaFimDeJogo();
				if (resolvendo == true && resultado==0){
					MontaJogo.resolveJogo();
				}
			}
		});
		botao[2][1].setBounds(150, 180, 120, 75);
		
		botao[2][2] = new Button(this, SWT.NONE);
		botao[2][2].setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));	
		botao[2][2].addSelectionListener(new SelectionAdapter() {
			

			@Override
			public void widgetSelected(SelectionEvent e) {
				MontaJogo.moveVazioClick(2,2);
				resultado = MontaJogo.verificaFimDeJogo();
				if (resolvendo == true && resultado==0){
					MontaJogo.resolveJogo();
				}
			}
		});
		botao[2][2].setBounds(290, 180, 120, 75);
		
		Label vert02 = new Label(this, SWT.SEPARATOR | SWT.VERTICAL);
		vert02.setBounds(276, 10, 8, 245);
		
		Label vert01 = new Label(this, SWT.SEPARATOR | SWT.VERTICAL);
		vert01.setBounds(136, 10, 8, 245);
		
		Label hori01 = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		hori01.setBounds(10, 90, 400, 5);
		
		Label hori02 = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		hori02.setBounds(10, 175, 400, 5);
		
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		resolverJogo = new MenuItem(menu, SWT.NONE);
		resolverJogo.setSelection(true);
		resolverJogo.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Janela.resolvendo = true;
				MontaJogo.numeroJogadas=0;
				instrucaoDoJogo.setText("Número de Jogadas: "+MontaJogo.numeroJogadas);
				
				MontaJogo.resolveJogo();
			}
		});
		resolverJogo.setText("Resolver ");
		
		jogarNovamente = new MenuItem(menu, SWT.NONE);
		jogarNovamente.setSelection(true);
		jogarNovamente.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				MontaJogo.jogoInicial();
			}
		});
		jogarNovamente.setText("Jogar novamente");
		
		Label lblInstrues = new Label(this, SWT.NONE);
		lblInstrues.setBounds(426, 10, 70, 15);
		lblInstrues.setText("Instru\u00E7\u00F5es:");
		
		instrucaoDoJogo = new StyledText(this, SWT.BORDER);
		instrucaoDoJogo.setEnabled(false);
		instrucaoDoJogo.setEditable(false);
		instrucaoDoJogo.setBounds(427, 31, 141, 224);
		createContents();
		
		MontaJogo.jogoInicial();	
	}
	
	
	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Jogo dos oito");
		setSize(594, 321);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
