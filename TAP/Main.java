import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

//classe ingrediente: 

class AppendableObjectOutputStream extends ObjectOutputStream
{

  public AppendableObjectOutputStream(OutputStream out) throws IOException 
  {
    super(out);
  }

  @Override
  protected void writeStreamHeader() throws IOException 
  {
     //reset();
  }

}

@SuppressWarnings("unchecked")
class Pesquisa
{
	public static Receita receita_escolhida(String nome)
	{
		Receita temp = null;
		try
		{
			FileInputStream fis = new FileInputStream("receitas.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			java.util.List<Receita> receitateste =  null;
			try
			{
				while(true)
				{
					receitateste = (java.util.List<Receita>) ois.readObject();
					for (Receita card : receitateste)
					{
						if(nome.equals(card.getNomeReceita()))
							temp = card;
					}
					
				}
			}
			catch (EOFException er) 
			{
		 	 // ... sempre da essa exception, mas nao interfere na execucao
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
		return temp;
	}

	public static int tem_no_estoque(String nome)
	{
		int temp = 0;
		try
		{
			FileInputStream fis = new FileInputStream("receitas.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			java.util.List<Receita> receitateste =  null;
			try
			{
				while(true)
				{
					receitateste = (java.util.List<Receita>) ois.readObject();
					for (Receita card : receitateste)
					{
						if(nome.equals(card.getNomeReceita()))
							temp = 1;
					}
					
				}
			}
			catch (EOFException er) 
			{
		 	 // ... sempre da essa exception, mas nao interfere na execucao
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
		return temp;
	}

	public static Ingrediente ingredientes(String nome)
	{
			Ingrediente temp = null;
			try
			{
				FileInputStream fis = new FileInputStream("estoque.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
				java.util.List<Ingrediente> ingredieteste = null;
				try
				{
					while(true)
					{
						ingredieteste = (java.util.List<Ingrediente>) ois.readObject();
						for (Ingrediente card : ingredieteste)
						{
							if (nome.equals(card.getNome()))
								temp = card;
						}	
					}
				}
				catch(EOFException er)
				{

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
			return temp;
	}
}

@SuppressWarnings("unchecked")
public class Main extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	static String nome_receita_escolhida;
	static int quantidade_escolhida;

	private JButton B1,B2,B3,B4,QUIT;
	private JLabel L1, L2;
	private JTextField T1,T2;

	private JMenuBar barra;
 	private JMenu menu;
 	private JMenu menu2;
 	private JMenuItem verEstoque;
 	private JDesktopPane desktop;

	public Main()
	{
		super( "Andrey Lindo" );
		B1 = new JButton("<html>Add ingredientes<br />(estoque)</html>"); //html e tals só para quebrar a linha
		B1.addActionListener(this);
		B2 = new JButton("Montar Refeicao");
		B2.addActionListener(this);
		B3= new JButton("Criar Receita");
		B3.addActionListener(this);
		B4= new JButton("Ver receitas");
		B4.addActionListener(this);
		QUIT = new JButton("Sair");
		QUIT.addActionListener(this);
		this.barra = new JMenuBar();
		this.menu = new JMenu( "File" );
		this.menu2 = new JMenu("Ajuda");
 		this.verEstoque = new JMenuItem( "Estoque" );
 		this.menu.add( this.verEstoque );
 		this.barra.add( this.menu );
 		this.barra.add(this.menu2);
		this.getContentPane().setLayout(new BorderLayout());
		this.setJMenuBar( this.barra ); 
		this.desktop = new JDesktopPane();
		this.getContentPane().add( this.desktop );
		verEstoque.addActionListener(this);
		this.getContentPane().add(B1, BorderLayout.WEST);
		this.getContentPane().add(B2, BorderLayout.EAST);
		this.getContentPane().add(B3, BorderLayout.CENTER);
		this.getContentPane().add(B4, BorderLayout.PAGE_START);
		this.getContentPane().add(QUIT, BorderLayout.PAGE_END);		
		this.setLocation(300,200);
		this.setSize(500,400);
	}

	//aqui vai o código para tratar os eventos dos botôes
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if (e.getSource() == B1)
			{
				//add novo produto
				JFrame janela2 = new AddIngredientes();
				janela2.setVisible(true);
			}
			if (e.getSource() == B2)
			{
				//cria janelinha q 
				JFrame janela3 = new MontarRefeicao();
				janela3.setVisible(true);
			}
			if (e.getSource() == B3)
			{
				//add novo produto
				JFrame janela3 = new NovaReceita();
				janela3.setVisible(true);
			}
			if (e.getSource() == QUIT)
			{
				System.exit(0);
			}
			if (e.getSource() == B4)
			{
				File arquivo = new File("receitas.txt");
				
				if(!arquivo.exists())
				{
					String backup = "Não há receitas";
					JOptionPane.showMessageDialog(null,
        			"Erro: '" + backup + "'.",
        			"Backup problem",
       				 JOptionPane.INFORMATION_MESSAGE);
				}else
				{
					JFrame janela4 = new VerReceita();
					janela4.setVisible(true);
				}
			}
			if (e.getSource() == verEstoque)
			{
				File arquivo = new File("estoque.txt");
				
				if(!arquivo.exists())
				{
					String backup = "Estoque vazio";
					JOptionPane.showMessageDialog(null,
        			"Erro: '" + backup + "'.",
        			"Backup problem",
       				 JOptionPane.INFORMATION_MESSAGE);
				}else{
					FileInputStream fis = new FileInputStream("estoque.txt");
					ObjectInputStream ois = new ObjectInputStream(fis);
					java.util.List<Ingrediente> estoqueIngredientes =  null;
					String[] choices = new String[100];
					int i = 0;
					try
					{
						while(true)
						{
							estoqueIngredientes = (java.util.List<Ingrediente>) ois.readObject();
							for (Ingrediente card : estoqueIngredientes)
							{
						      	choices[i] =  card.getNome() + "    " + card.getQuantidade();
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
				}
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
	}

	public static void main(String args[]) 
	{
		JFrame janela = new Main();
		janela.setVisible(true);
		WindowListener x = new WindowAdapter ()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		};
		janela.addWindowListener(x);
	}
}
