package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlIncluirContaBancaria;
import controller.CtrlPrograma;

public class JanelaPrincipal extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal(CtrlPrograma c) {
		super(c);
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btIncluirPessoa = new JButton("Incluir Pessoa");
		btIncluirPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getCtrl();
				ctrl.iniciarIncluirPessoa();
			}
		});
		btIncluirPessoa.setBounds(10, 55, 127, 63);
		contentPane.add(btIncluirPessoa);
		
		JButton btIncluirContaBancaria = new JButton("Incluir Conta Bancária");
		btIncluirContaBancaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getCtrl();
				ctrl.iniciarIncluirContaBancaria();
			}
		});
		btIncluirContaBancaria.setBounds(181, 55, 227, 63);
		contentPane.add(btIncluirContaBancaria);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getCtrl();
				ctrl.finalizar();
			}
		});
		btSair.setBounds(309, 162, 99, 63);
		contentPane.add(btSair);
		
		JButton btIncluirAgenciaBancaria = new JButton("Incluir Agência Bancária");
		btIncluirAgenciaBancaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getCtrl();
				ctrl.iniciarIncluirAgenciaBancaria();
			}
		});
		btIncluirAgenciaBancaria.setBounds(10, 162, 227, 63);
		contentPane.add(btIncluirAgenciaBancaria);
		this.setVisible(true);
	}
}
