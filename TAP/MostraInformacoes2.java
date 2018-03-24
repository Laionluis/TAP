import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class MostraInformacoes2 extends JFrame implements ActionListener
{	
	private JButton ESCOLHER_RECEITA,FINALIZAR;
	private JLabel L1, L2, L3, L4;
	private JTextField T1,T2,T3,T4;
	private Container container;
	private GridLayout gridLayout1;
	private JTextArea textArea;
	private JScrollPane jScrollPane1 ;
	public MostraInformacoes2()
	{
		super("Dados");
		SpringLayout layout = new SpringLayout();
		container = getContentPane();  //OBTÉM O PAINEL DE CONTEÚDO
		container.setLayout(layout);
		L1 = new JLabel("Receita escolhida:");
		T1 = new JTextField(10);
		T1.setText(Main.nome_receita_escolhida);
		T1.setEditable(false);
		L3 = new JLabel("Caloria:");
		T3 = new JTextField(10);
		L4 = new JLabel("Modo de preparo:");
		textArea = new JTextArea(12, 28);
		textArea.setFont(new Font("Serif", Font.ITALIC, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		jScrollPane1 = new JScrollPane(textArea);
		jScrollPane1.validate();

		Receita temp; 
		temp = Pesquisa.receita_escolhida(Main.nome_receita_escolhida); //pesquisa a receita toda 
		textArea.append(temp.getModoPreparo());
		textArea.setEditable(false);

		container.add(L1);
		container.add(T1);
		layout.putConstraint(SpringLayout.WEST, L1, 10, SpringLayout.WEST, container);
	    layout.putConstraint(SpringLayout.NORTH, L1, 25, SpringLayout.NORTH, container);
	    layout.putConstraint(SpringLayout.NORTH, T1, 25, SpringLayout.NORTH, container);
	    layout.putConstraint(SpringLayout.WEST, T1, 10, SpringLayout.EAST, L1);

	    container.add(L3);
		container.add(T3);
		layout.putConstraint(SpringLayout.WEST, L3, 10, SpringLayout.WEST, container);
	    layout.putConstraint(SpringLayout.NORTH, L3, 50, SpringLayout.NORTH, container);
	    layout.putConstraint(SpringLayout.NORTH, T3, 50, SpringLayout.NORTH, container);
	    layout.putConstraint(SpringLayout.WEST, T3, 72, SpringLayout.EAST, L3);

	    container.add(L4);
		container.add(jScrollPane1);
		layout.putConstraint(SpringLayout.WEST, L4, 10, SpringLayout.WEST, container);
	    layout.putConstraint(SpringLayout.NORTH, L4, 77, SpringLayout.NORTH, container);
	    layout.putConstraint(SpringLayout.NORTH, jScrollPane1, 72, SpringLayout.NORTH, container);
	    layout.putConstraint(SpringLayout.WEST, jScrollPane1, 15, SpringLayout.EAST, L4);
		
		this.setLocation(400,100);
		this.setSize(500,400);	
	}
	
	//TRATA EVENTOS
	public void actionPerformed(ActionEvent event)
	{

	}	
}
