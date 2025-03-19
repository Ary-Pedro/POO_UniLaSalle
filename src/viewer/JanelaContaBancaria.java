package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.CtrlIncluirContaBancaria;
import model.AgenciaBancaria;
import model.Pessoa;

public class JanelaContaBancaria extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	//
	// Atributos dos Componentes Gráficos
	//
	private JPanel contentPane;
	private JTextField tfNumero;
	private JTextField tfLimite;
	private JTextField tfSaldo;
	private JComboBox cbCorrentista;
	private JComboBox cbAgencia;
	
	/**
	 * Create the frame.
	 */
	public JanelaContaBancaria(CtrlIncluirContaBancaria c, 
			                   Pessoa[] conjPessoas, 
			                   AgenciaBancaria[] conjAgencias) {
		super(c);
		setTitle("Conta Bancária");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número da Conta:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 37, 101, 14);
		contentPane.add(lblNewLabel);
		
		tfNumero = new JTextField();
		tfNumero.setBounds(121, 37, 86, 20);
		contentPane.add(tfNumero);
		tfNumero.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Limite:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 86, 101, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Saldo:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 137, 101, 14);
		contentPane.add(lblNewLabel_2);
		
		tfLimite = new JTextField();
		tfLimite.setBounds(121, 86, 145, 20);
		contentPane.add(tfLimite);
		tfLimite.setColumns(10);
		
		tfSaldo = new JTextField();
		tfSaldo.setBounds(121, 137, 145, 20);
		contentPane.add(tfSaldo);
		tfSaldo.setColumns(10);
		
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
				
				aux = tfLimite.getText();
				double limite;
				try {
					limite = Double.parseDouble(aux);
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor de limite Inválido: " + aux);
					return;
				}
				
				aux = tfSaldo.getText();
				double saldo;
				try {
					saldo = Double.parseDouble(aux);
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor de saldo Inválido: " + aux);
					return;
				}
				CtrlIncluirContaBancaria ctrl = (CtrlIncluirContaBancaria)getCtrl();
				ctrl.efetuarInclusao(numero, limite, saldo, 
						             (Pessoa)cbCorrentista.getSelectedItem(), 
						             (AgenciaBancaria)cbAgencia.getSelectedItem());
			}
		});
		btOk.setBounds(131, 269, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlIncluirContaBancaria ctrl = (CtrlIncluirContaBancaria)getCtrl();
				ctrl.finalizar();
			}
		});
		btCancelar.setBounds(297, 269, 89, 23);
		contentPane.add(btCancelar);
		
		JLabel lblNewLabel_2_1 = new JLabel("Correntista:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setBounds(10, 179, 101, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btIncluirPessoa = new JButton("Incluir Novo Correntista");
		btIncluirPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlIncluirContaBancaria ctrl = (CtrlIncluirContaBancaria)getCtrl();
				ctrl.iniciarIncluirPessoa();
			}
		});
		btIncluirPessoa.setBounds(327, 175, 213, 23);
		contentPane.add(btIncluirPessoa);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Agência:");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1.setBounds(10, 226, 101, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		JButton btAgencia = new JButton("Incluir Nova Agência");
		btAgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlIncluirContaBancaria ctrl = (CtrlIncluirContaBancaria)getCtrl();
				ctrl.iniciarIncluirAgenciaBancaria();
			}
		});
		btAgencia.setBounds(327, 222, 213, 23);
		contentPane.add(btAgencia);
		
		cbCorrentista = new JComboBox(conjPessoas);
		cbCorrentista.setBounds(121, 175, 185, 22);
		contentPane.add(cbCorrentista);
		
		cbAgencia = new JComboBox(conjAgencias);
		cbAgencia.setBounds(121, 222, 185, 22);
		contentPane.add(cbAgencia);
		this.setVisible(true);
	}
	
	public void atualizarCorrentista(Pessoa nova) {
		this.cbCorrentista.addItem(nova);
		this.cbCorrentista.setSelectedItem(nova);
	}

	public void atualizarAgencia(AgenciaBancaria nova) {
		this.cbAgencia.addItem(nova);
		this.cbAgencia.setSelectedItem(nova);
	}
}
