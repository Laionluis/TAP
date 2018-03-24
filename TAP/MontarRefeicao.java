import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class MontarRefeicao extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;

	private JButton ESCOLHER_RECEITA,FINALIZAR;
	private JLabel L1, L2, L3, L4;
	private JTextField T1,T2,T3,T4;

	public MontarRefeicao()
	{
		super("Montar Refeicao");
		ESCOLHER_RECEITA = new JButton("ESCOLHER RECEITA");
		ESCOLHER_RECEITA.addActionListener(this);
		FINALIZAR = new JButton("Finalizar");
		FINALIZAR.addActionListener(this);
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		L1 = new JLabel("Receita:");
		T1 = new JTextField(10);

		L2 = new JLabel("Quantidade:");
		T2 = new JTextField(10);
		this.getContentPane().setLayout(gridbag);
		
		c.gridy = 0;
		c.gridx= 0;
		gridbag.setConstraints(ESCOLHER_RECEITA, c);
		this.getContentPane().add(ESCOLHER_RECEITA);

		c.gridy = 1;
		c.gridx= 0;
		gridbag.setConstraints(L1, c);
		this.getContentPane().add(L1);
		c.gridy = 1;
		c.gridx= 1;
		gridbag.setConstraints(T1, c);
		this.getContentPane().add(T1);

		c.gridy = 2;
		c.gridx= 0;
		gridbag.setConstraints(L2, c);
		this.getContentPane().add(L2);
		c.gridy = 2;
		c.gridx= 1;
		gridbag.setConstraints(T2, c);
		this.getContentPane().add(T2);
		
		c.gridy = 5;
		c.gridx= 0;
		gridbag.setConstraints(FINALIZAR, c);
		this.getContentPane().add(FINALIZAR);
		
		this.setLocation(400,300);
		this.setSize(400,300);
	}

	public void actionPerformed(ActionEvent e) 
	{
		try
		{
			FileInputStream fis = new FileInputStream("receitas.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			java.util.List<Receita> receitateste =  null;
			Receita receita_escolhida;
			if (e.getSource() == ESCOLHER_RECEITA)
			{
				String[] choices = new String[100];
				int i = 0;
				try
				{
					while(true)
					{
						receitateste = (java.util.List<Receita>) ois.readObject();
						for (Receita card : receitateste)
						{
					      	choices[i] = card.getNomeReceita();
					      	i++;
						}
						
					}
				}
				catch (EOFException er) 
				{
		 		 // ... sempre da essa exception, mas nao interfere na execucao
				}
				ois.close();
				String input = (String) JOptionPane.showInputDialog(null, "Receitas disponiveis:",
	        	"Escolha uma receita", JOptionPane.QUESTION_MESSAGE, null, 
	        	choices, // Array of choices
	        	choices[0]); // Initial choice
	        	Main.nome_receita_escolhida = input;
	        	T1.setText(Main.nome_receita_escolhida);
	        	T1.setEditable(false);
			}
		}
		catch(IOException erro)
		{
			erro.printStackTrace();
		}
		catch(ClassNotFoundException errou)
		{
			errou.printStackTrace();
		}
		if (e.getSource() == FINALIZAR)
		{
			if(!(T1.getText().equals("")))
			{
				Main.quantidade_escolhida = Integer.parseInt(T2.getText());
				super.dispose(); //fecha janelinha
				JFrame janela = new MostraInformacoes();
				janela.setVisible(true);
				//vai fechar janela atual, e abrir outra com todas as informaçoes
			}
		}
	}
}