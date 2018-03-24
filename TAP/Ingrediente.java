import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Ingrediente implements Serializable     //serializable permite que a classe seja salva num arquivo
{
	private static final long serialVersionUID = 1L;

	private String nome;
	private double caloria;
	private double quantidade;

	public Ingrediente(String nome,double caloria,double quantidade)
	{
		this.nome=nome;
		this.caloria=caloria;
		this.quantidade = quantidade;
	}

	public Ingrediente(String nome,double quantidade)
	{
		this.nome=nome;
		this.quantidade = quantidade;
	}

	public void setNome(String nome)
	{
	    nome = nome;
	}

	public String getNome()
	{
	    return nome;
	}

	public void setCaloria(double caloria)
	{
	    caloria = caloria;
	}	

	public double getCaloria()
	{
	    return caloria;
	}	

	public void setQuantidade(double quantidade)
	{
	    quantidade = quantidade;
	}	

	public double getQuantidade()
	{
	    return quantidade;
	}	

}