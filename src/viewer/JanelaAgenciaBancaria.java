package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.CtrlIncluirAgenciaBancaria;

public class JanelaAgenciaBancaria extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	//
	// Atributos dos Componentes Gráficos
	//
	private JPanel contentPane;
	private JTextField tfNumero;
	private JTextField tfEndereco;
	private JTextField tfCidade;
	
	/**
	 * Create the frame.
	 */
	public JanelaAgenciaBancaria(CtrlIncluirAgenciaBancaria c) {
		super(c);
		setTitle("Agência Bancária");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 37, 49, 14);
		contentPane.add(lblNewLabel);
		
		tfNumero = new JTextField();
		tfNumero.setBounds(69, 34, 86, 20);
		contentPane.add(tfNumero);
		tfNumero.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Endereço:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 86, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cidade:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 137, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		tfEndereco = new JTextField();
		tfEndereco.setBounds(69, 86, 322, 20);
		contentPane.add(tfEndereco);
		tfEndereco.setColumns(10);
		
		tfCidade = new JTextField();
		tfCidade.setBounds(69, 137, 101, 20);
		contentPane.add(tfCidade);
		tfCidade.setColumns(10);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Provisoriamente faremos assim!
				String aux = tfNumero.getText();
				int numero;
				try {
					numero = Integer.parseInt(aux);
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Número de Conta Inválido: " + aux);
					return;
				}
				
				String endereco = tfEndereco.getText();				
				String cidade = tfCidade.getText();
				
				CtrlIncluirAgenciaBancaria ctrl = (CtrlIncluirAgenciaBancaria)getCtrl();
				ctrl.efetuarInclusao(numero, endereco, cidade);
			}
		});
		btOk.setBounds(85, 200, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlIncluirAgenciaBancaria ctrl = (CtrlIncluirAgenciaBancaria)getCtrl();
				ctrl.finalizar();
			}
		});
		btCancelar.setBounds(251, 200, 89, 23);
		contentPane.add(btCancelar);
		this.setVisible(true);
	}
}
