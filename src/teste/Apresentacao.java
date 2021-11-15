package teste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Apresentacao {
	DecimalFormat df = new DecimalFormat("0.00");
	private JFrame frame;
	private JTextField tfNome;
	private JTextField tfSalario;
	private JTextField tfAluguel;
	private JTextField tfCondominio;
	private JTextField tfNomeCurso;
	private JTextField tfDesconto;
	private JTextField tfValor;
	private ArrayList<Pessoa> pessoas = new ArrayList<>();
	private JTextField tfQtdPessoas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Apresentacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 338, 664);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 179, 305, 22);
		frame.getContentPane().add(comboBox);

		JButton btnCadastra = new JButton("Cadastrar Pessoa");

		JLabel lblNewLabel = new JLabel("S\u00E1lario: R$");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 75, 75, 19);
		frame.getContentPane().add(lblNewLabel);

		tfNome = new JTextField();
		tfNome.setBounds(92, 37, 223, 20);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 36, 75, 19);
		frame.getContentPane().add(lblNewLabel_1);

		tfSalario = new JTextField();
		tfSalario.setBounds(92, 76, 223, 20);
		frame.getContentPane().add(tfSalario);
		tfSalario.setColumns(10);

		JButton btnCalcularIRPF = new JButton("Calcular IRPF/INSS");
		btnCalcularIRPF.setEnabled(false);
		btnCalcularIRPF.setBounds(10, 222, 305, 29);
		frame.getContentPane().add(btnCalcularIRPF);

		JLabel lblNewLabel_2 = new JLabel("Aluguel: R$");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 394, 75, 19);
		frame.getContentPane().add(lblNewLabel_2);

		tfAluguel = new JTextField();
		tfAluguel.setBounds(116, 395, 199, 20);
		frame.getContentPane().add(tfAluguel);
		tfAluguel.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Condom\u00EDnio: R$");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 425, 113, 19);
		frame.getContentPane().add(lblNewLabel_3);

		tfCondominio = new JTextField();
		tfCondominio.setBounds(116, 426, 199, 20);
		frame.getContentPane().add(tfCondominio);
		tfCondominio.setColumns(10);
		
		tfQtdPessoas = new JTextField();
		tfQtdPessoas.setBounds(116, 457, 196, 20);
		frame.getContentPane().add(tfQtdPessoas);
		tfQtdPessoas.setColumns(10);

		JButton btnCurso = new JButton("Adicionar Curso");
		btnCurso.setEnabled(false);
		
		btnCurso.setBounds(10, 354, 305, 29);
		frame.getContentPane().add(btnCurso);

		JButton btnAluguel = new JButton("Adicionar Alguel");
		btnAluguel.setEnabled(false);
		btnAluguel.setBounds(10, 501, 305, 29);
		frame.getContentPane().add(btnAluguel);

		JButton btnResumo = new JButton("Resumo");
		btnResumo.setEnabled(false);
		btnResumo.setBounds(10, 581, 305, 29);
		frame.getContentPane().add(btnResumo);

		JLabel lblNewLabel_4 = new JLabel("Valor do curso: R$");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 324, 138, 19);
		frame.getContentPane().add(lblNewLabel_4);

		tfNomeCurso = new JTextField();
		tfNomeCurso.setBounds(138, 262, 177, 20);
		frame.getContentPane().add(tfNomeCurso);
		tfNomeCurso.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Desconto:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 293, 91, 20);
		frame.getContentPane().add(lblNewLabel_5);

		tfDesconto = new JTextField();
		tfDesconto.setBounds(139, 293, 145, 20);
		frame.getContentPane().add(tfDesconto);
		tfDesconto.setColumns(10);

		JButton btnRestante = new JButton("Restante do S\u00E1lario");
		btnRestante.setEnabled(false);
		btnRestante.setBounds(10, 541, 305, 29);
		frame.getContentPane().add(btnRestante);

		JLabel lblNewLabel_6 = new JLabel("Nome:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 262, 99, 17);
		frame.getContentPane().add(lblNewLabel_6);

		tfValor = new JTextField();
		tfValor.setText("");
		tfValor.setBounds(138, 325, 177, 20);
		frame.getContentPane().add(tfValor);
		tfValor.setColumns(10);

		btnCadastra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfSalario.getText().isBlank() && tfNome.getText().isBlank()) {
						throw new IllegalArgumentException("� necessario preencher os campos");
					} else if (tfNome.getText().isBlank()) {
						throw new IllegalArgumentException("� necessario preencher o nome");
					} else if (tfSalario.getText().isBlank()) {
						throw new IllegalArgumentException("� necessario preencher o sal�rio");
					} else {
						Pessoa p = new Pessoa(tfNome.getText(), Double.parseDouble(tfSalario.getText()));
						pessoas.add(p);
						comboBox.addItem(p);
						btnCalcularIRPF.setEnabled(true);
						btnAluguel.setEnabled(true);
						btnCurso.setEnabled(true);
						btnRestante.setEnabled(true);
						btnResumo.setEnabled(true);
						tfSalario.setText("");
						tfNome.setText("");
					}

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "O sal�rio deve ser informado em numeros");
				} catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae.getMessage());
				}
			}
		}	
		);
		btnCadastra.setBounds(10, 118, 305, 29);
		frame.getContentPane().add(btnCadastra);
		
		JLabel lblNewLabel_7 = new JLabel("N\u00BA de Pessoas:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(10, 455, 113, 22);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("%");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(294, 293, 18, 20);
		frame.getContentPane().add(lblNewLabel_8);
		
		
		
		btnCalcularIRPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa p = (Pessoa)comboBox.getSelectedItem();
				JOptionPane.showMessageDialog(null, "O valor a pagar de INSS: R$ "+df.format(p.calculoINSS())+
													"\nO valor a pagar de IRPF: R$ "+df.format(p.calculoIRPF()));
			}
		});
		
		btnCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa p = (Pessoa)comboBox.getSelectedItem();
				if (p.getCurso() == null) {
					try {
						if (tfNomeCurso.getText().isBlank() && tfValor.getText().isBlank() && tfDesconto.getText().isBlank()) {
							throw new IllegalArgumentException("� necessario preencher os campos");
						} else if (tfNomeCurso.getText().isBlank()) {
							throw new IllegalArgumentException("� necessario preencher o nome do curso");
						} else if (tfValor.getText().isBlank()) {
							throw new IllegalArgumentException("� necessario preencher o valor a pagar do curso");
						} else if (tfDesconto.getText().isBlank()) {
							throw new IllegalArgumentException("� necessario preencher o valor do desconto, caso n�o exista preencher com 0");
						} else {
							Curso c = new Curso(tfNomeCurso.getText(), Double.parseDouble(tfValor.getText()), Integer.parseInt(tfDesconto.getText()));
							p.setCurso(c);
							JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso");
							tfNomeCurso.setText("");
							tfValor.setText("");
							tfDesconto.setText("");
						}	

					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Os valores desconto e valor do curso devem ser informado em numerais");
					} catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae.getMessage());
					}
				} else {
					int resposta = JOptionPane.showConfirmDialog(null, "Esta pessoa ja est� com um curso registrado: "+p.getCurso().getNome()+"\nDeseja alterar?");
					if (resposta == JOptionPane.YES_OPTION) {
						try {
							if (tfNomeCurso.getText().isBlank() && tfValor.getText().isBlank() && tfDesconto.getText().isBlank()) {
								throw new IllegalArgumentException("� necessario preencher os campos");
							} else if (tfNomeCurso.getText().isBlank()) {
								throw new IllegalArgumentException("� necessario preencher o nome do curso");
							} else if (tfValor.getText().isBlank()) {
								throw new IllegalArgumentException("� necessario preencher o valor a pagar do curso");
							} else if (tfDesconto.getText().isBlank()) {
								throw new IllegalArgumentException("� necessario preencher o valor do desconto, caso n�o exista preencher com 0");
							} else {
								Curso c = new Curso(tfNomeCurso.getText(), Double.parseDouble(tfValor.getText()), Integer.parseInt(tfDesconto.getText()));
								p.setCurso(c);
								JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso");
								tfNomeCurso.setText("");
								tfValor.setText("");
								tfDesconto.setText("");
							}	

						} catch (NumberFormatException nfe) {
							JOptionPane.showMessageDialog(null, "Os valores desconto e valor do curso devem ser informado em numerais");
						} catch (IllegalArgumentException iae) {
						JOptionPane.showMessageDialog(null, iae.getMessage());
						}
					} else {
						JOptionPane.showMessageDialog(null, "Curso n�o alterado");
					}
				}
				
			
		}
			}
		);
		
		btnAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa p = (Pessoa)comboBox.getSelectedItem();
				if (p.getAluguel() == null) {
					try {
						if (tfAluguel.getText().isBlank() && tfCondominio.getText().isBlank() && tfQtdPessoas.getText().isBlank()) {
							throw new IllegalArgumentException("� necessario preencher os campos");
						} else if (tfAluguel.getText().isBlank()) {
							throw new IllegalArgumentException("� necessario preencher o aluguel");
						} else if (tfCondominio.getText().isBlank()) {
							throw new IllegalArgumentException("� necessario preencher o valor do condominio, caso n�o exista preencher com 0");
						} else if (tfQtdPessoas.getText().isBlank()) {
							throw new IllegalArgumentException("� necessario preencher o N� de Pessoas");
						} else {
							Aluguel a = new Aluguel(Double.parseDouble(tfAluguel.getText()), Double.parseDouble(tfCondominio.getText()), Integer.parseInt(tfQtdPessoas.getText()));
							p.setAluguel(a);
							JOptionPane.showMessageDialog(null, "Alguel cadastrado com sucesso");
							tfQtdPessoas.setText("");
							tfAluguel.setText("");
							tfCondominio.setText("");
						}	

					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Os valores devem ser informado em numerais");
					} catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae.getMessage());
					}
			} else {
				int resposta = JOptionPane.showConfirmDialog(null, "Esta pessoa ja está com um aluguel registrado"+
						"\nValor: R$ "+p.getAluguel().getAluguel()+
						"\nCondomino: R$ "+p.getAluguel().getCondominio()+
						"\nN de Pessoas: "+ p.getAluguel().getQtdPessoas()+
						"\nDeseja alterar?");
				if (resposta == JOptionPane.YES_OPTION) {
					try {
						if (tfAluguel.getText().isBlank() && tfCondominio.getText().isBlank() && tfQtdPessoas.getText().isBlank()) {
							throw new IllegalArgumentException("É necessario preencher os campos");
						} else if (tfAluguel.getText().isBlank()) {
							throw new IllegalArgumentException("É necessario preencher o aluguel");
						} else if (tfCondominio.getText().isBlank()) {
							throw new IllegalArgumentException("É necessario preencher o valor do condominio, caso n�o exista preencher com 0");
						} else if (tfQtdPessoas.getText().isBlank()) {
							throw new IllegalArgumentException("É necessario preencher o N� de Pessoas");
						} else {
							Aluguel a = new Aluguel(Double.parseDouble(tfAluguel.getText()), Double.parseDouble(tfCondominio.getText()), Integer.parseInt(tfQtdPessoas.getText()));
							p.setAluguel(a);
							JOptionPane.showMessageDialog(null, "Alguel cadastrado com sucesso");
							tfQtdPessoas.setText("");
							tfAluguel.setText("");
							tfCondominio.setText("");
						}	

					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Os valores devem ser informado em numerais");
					} catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, iae.getMessage());
					}
				}
			}
		}});
		
		btnRestante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa p = (Pessoa)comboBox.getSelectedItem();
				JOptionPane.showMessageDialog(null, "Valor restante do sálario: R$ "+df.format(p.restanteDoSalario()));
			}
		});
		
		btnResumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa p = (Pessoa)comboBox.getSelectedItem();
				Curso c = p.getCurso();
				Aluguel a = p.getAluguel();
				if (c == null && a == null) {
					JOptionPane.showMessageDialog(null, "Nome: "+ p.getNome()+
							"\nSálario atual: R$ "+ df.format(p.getSalario())+
							"\nImposto INSS: R$ "+ df.format(p.calculoINSS())+
							"\nImposto De Renda: R$ "+df.format(p.calculoIRPF())+
							"\nCurso: Não Cadastrado"+
							"\nAluguel : Não Cadastrado"+
							"\nRestante do salário: R$ "+df.format(p.restanteDoSalario()));
				} else if (a == null) {
					if (c.getDesconto() == 0) {
						JOptionPane.showMessageDialog(null, "Nome: "+ p.getNome()+
								"\nSálario atual: R$ "+ df.format(p.getSalario())+
								"\nImposto INSS: R$ "+ df.format(p.calculoINSS())+
								"\nImposto De Renda: R$ "+df.format(p.calculoIRPF())+
								"\nCurso: "+c.getNome()+
								"\nValor do Curso: R$ "+ df.format(c.getValor())+
								"\nAluguel : Não Cadastrado"+
								"\nRestante do salário: R$ "+df.format(p.restanteDoSalario()));
						
					} else {
						JOptionPane.showMessageDialog(null, "Nome: "+ p.getNome()+
								"\nSálario atual: R$ "+ df.format(p.getSalario())+
								"\nImposto De Renda: R$ "+df.format(p.calculoIRPF())+
								"\nImposto INSS: R$ "+ df.format(p.calculoINSS())+
								"\nCurso: "+c.getNome()+
								"\nValor do Curso: R$ "+ df.format(c.getValor())+
								"\nDesconto: "+c.getDesconto()+"%"+
								"\nValor do Curso a pagar: R$ "+df.format((c.getValor()-((c.getValor()*c.getDesconto())/100)))+
								"\nAluguel : Não Cadastrado"+
								"\nRestante do salário: R$ "+df.format(p.restanteDoSalario()));
					}
				} else if (c == null) {
					JOptionPane.showMessageDialog(null, "Nome: "+ p.getNome()+
							"\nSálario atual: R$ "+ df.format(p.getSalario())+
							"\nImposto De Renda: R$ "+df.format(p.calculoIRPF())+
							"\nImposto INSS: R$ "+ df.format(p.calculoINSS())+
							"\nCurso: Não Cadastrado"+
							"\nValor do Aluguel : R$ "+df.format(a.getAluguel())+
							"\nCondominio: R$ "+df.format(a.getCondominio())+
							"\nNumero de Pessoas: "+a.getQtdPessoas()+
							"\nValor a Pagar por Pessoas: R$ "+ df.format((a.getAluguel()+a.getCondominio())/(double)a.getQtdPessoas()) +
							"\nRestante do salário: R$ "+df.format(p.restanteDoSalario()));
				} else {
					if (c.getDesconto() == 0) {
						JOptionPane.showMessageDialog(null, "Nome: "+ p.getNome()+
								"\nSálario atual: R$ "+ df.format(p.getSalario())+
								"\nImposto De Renda: R$ "+df.format(p.calculoIRPF())+
								"\nImposto INSS: R$ "+ df.format(p.calculoINSS())+
								"\nCurso: "+c.getNome()+
								"\nValor do Curso: R$ "+ df.format(c.getValor())+
								"\nValor do Aluguel : R$ "+df.format(a.getAluguel())+
								"\nCondominio: R$ "+df.format(a.getCondominio())+
								"\nNumero de Pessoas: "+a.getQtdPessoas()+
								"\nValor a Pagar por Pessoas: R$ "+ df.format((a.getAluguel()+a.getCondominio())/(double)a.getQtdPessoas()) +
								"\nRestante do salário: R$ "+df.format(p.restanteDoSalario()));
					} else {
						JOptionPane.showMessageDialog(null, "Nome: "+ p.getNome()+
								"\nSálario atual: R$ "+ df.format(p.getSalario())+
								"\nImposto De Renda: R$ "+df.format(p.calculoIRPF())+
								"\nImposto INSS: R$ "+ df.format(p.calculoINSS())+
								"\nCurso: "+c.getNome()+
								"\nValor do Curso: R$ "+ df.format(c.getValor())+
								"\nDesconto: "+c.getDesconto()+"%"+
								"\nValor do Curso a pagar: R$ "+df.format((c.getValor()-((c.getValor()*c.getDesconto())/100)))+
								"\nValor do Aluguel : R$ "+df.format(a.getAluguel())+
								"\nCondominio: R$ "+df.format(a.getCondominio())+
								"\nNumero de Pessoas: "+a.getQtdPessoas()+
								"\nValor a Pagar por Pessoas: R$ "+ df.format((a.getAluguel()+a.getCondominio())/(double)a.getQtdPessoas()) +
								"\nRestante do salário: R$ "+df.format(p.restanteDoSalario()));
					}	
				}	
			}
		});

	}
}
