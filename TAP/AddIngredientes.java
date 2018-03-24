import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


public class AddIngredientes extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	java.util.List<Ingrediente> ingredientes =  new ArrayList<Ingrediente>();

	private JButton ADDINGREDIENTE,FINALIZAR;
	private JLabel L1, L2, L3, L4;
	private JTextField T1,T2,T3,T4;

	public AddIngredientes()
	{
		super( "Andrey Lindo" );
		ADDINGREDIENTE = new JButton("Add Ingrediente  ");
		ADDINGREDIENTE.addActionListener(this);
		FINALIZAR = new JButton("Finalizar");
		FINALIZAR.addActionListener(this);
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		L1 = new JLabel("Nome:");
		T1 = new JTextField(10);
		L2 = new JLabel("Caloria(100g):");
		T2 = new JTextField(10);	
		L3 = new JLabel("Quantidade:");
		T3 = new JTextField(10);	
		this.getContentPane().setLayout(gridbag);
		
		gridbag.setConstraints(L1, c);
		this.getContentPane().add(L1);
		c.gridy = 0;
		c.gridx= 1;
		gridbag.setConstraints(T1, c);
		this.getContentPane().add(T1);
		c.gridy = 1;
		c.gridx= 0;
		
		gridbag.setConstraints(L2, c);
		this.getContentPane().add(L2);
		c.gridy = 1;
		c.gridx= 1;
		gridbag.setConstraints(T2, c);
		this.getContentPane().add(T2);
		c.gridy = 2;
		c.gridx= 0;
		
		gridbag.setConstraints(L3, c);
		this.getContentPane().add(L3);
		c.gridy = 2;
		c.gridx= 1;
		gridbag.setConstraints(T3, c);
		this.getContentPane().add(T3);
		c.gridy = 3;
		c.gridx= 0;		
		
		gridbag.setConstraints(ADDINGREDIENTE, c);
		this.getContentPane().add(ADDINGREDIENTE);
		c.gridy = 4;
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
			File arquivo = new File("estoque.txt");	
			
			ObjectOutputStream escritor =null;

			if (!arquivo.exists())
			{
			 	escritor = new ObjectOutputStream (new FileOutputStream (arquivo));
			}
            else
            {
            	escritor = new AppendableObjectOutputStream (new FileOutputStream (arquivo, true));
			}
			//aqui vai o código para tratar os eventos dos botôes
			if (e.getSource() == ADDINGREDIENTE)  
			{
				JFrame temp = new JFrame();
				String aux = T1.getText();
				double aux1 =Double.parseDouble(T2.getText()); 
				double aux2 = Double.parseDouble(T3.getText());
				ingredientes.add(new Ingrediente(aux,aux1,aux2));
				JOptionPane.showMessageDialog(temp, "Ingrediente Adicionado");
				T1.setText("");		
				T2.setText("");
				T3.setText("");		
			}

			//adiciona a lista de objetos(nome e caloria) em um arquivo 
			
			if ((e.getSource() == FINALIZAR) && !(ingredientes.isEmpty()))
			{
				escritor.writeObject(ingredientes);
				escritor.reset();
				escritor.flush();
				escritor.close();
				super.dispose(); //fecha janelinha
			}
		}
		catch(IOException erro)
		{
			erro.printStackTrace();
		}
	}
}
