package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CtrlIncluirPessoa;
import model.ModelException;
import model.Pessoa;

public class JanelaPessoa extends JanelaAbstrata {
	
	private static final long serialVersionUID = 1L;
	//
	// ATRIBUTOS (Componentes Gráficos)
	//
	private JPanel contentPane;
	private JTextField tfCpf;
	private JTextField tfNome;
	private JTextField tfIdade;
	
	/**
	 * Create the frame.
	 */
	public JanelaPessoa(CtrlIncluirPessoa c) {
		super(c);
		setTitle("Pessoa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(39, 37, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(88, 34, 224, 20);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(39, 86, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Idade:");
		lblNewLabel_2.setBounds(39, 137, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		tfNome = new JTextField();
		tfNome.setBounds(88, 83, 288, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfIdade = new JTextField();
		tfIdade.setBounds(88, 134, 86, 20);
		contentPane.add(tfIdade);
		tfIdade.setColumns(10);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Recuperando os dados preenchidos pelo usuário
				String cpf = tfCpf.getText();
				String nome = tfNome.getText();
				String aux = tfIdade.getText();
				int idade;
				try {
					idade = Integer.parseInt(aux);
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Idade Inválida: " + aux);
					return;
				}
				
				// Informando ao controlador do caso de uso que ele 
				// deve efetuar a inclusão da pessoa
				CtrlIncluirPessoa ctrl = (CtrlIncluirPessoa)getCtrl();
				ctrl.efetuarInclusao(cpf, nome, idade);				
			}
		});
		btOk.setBounds(85, 200, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlIncluirPessoa ctrl = (CtrlIncluirPessoa)getCtrl();
				ctrl.finalizar();				
			}
		});
		btCancelar.setBounds(251, 200, 89, 23);
		contentPane.add(btCancelar);
		this.setVisible(true);
	}
}
