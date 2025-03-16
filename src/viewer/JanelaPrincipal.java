package viewer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlPrograma;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	//
	// Atributo de Relacionamento
	//
	final private CtrlPrograma ctrl; 
	/**
	 * Create the frame.
	 */
	public JanelaPrincipal(CtrlPrograma c) {
		this.ctrl = c;
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btIncluirPessoa = new JButton("Incluir Pessoa");
		btIncluirPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarIncluirPessoa();
			}
		});
		btIncluirPessoa.setBounds(10, 55, 127, 63);
		contentPane.add(btIncluirPessoa);
		
		JButton btIncluirContaBancaria = new JButton("Incluir Conta Bancária");
		btIncluirContaBancaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarIncluirContaBancaria();
			}
		});
		btIncluirContaBancaria.setBounds(181, 55, 227, 63);
		contentPane.add(btIncluirContaBancaria);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.encerrarPrograma();
			}
		});
		btSair.setBounds(449, 55, 99, 63);
		contentPane.add(btSair);
		this.setVisible(true);
	}
	
	public void notificar(String texto) {
		JOptionPane.showMessageDialog(null, texto);		
	}

	public void fechar() {
		this.setVisible(false);		
	}	
}
