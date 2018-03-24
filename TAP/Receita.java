import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Receita implements Serializable   //serializable permite que a classe seja salva num arquivo
{
	private static final long serialVersionUID = 1L;

	private String nomeReceita;
	private String modoPreparo;
	private java.util.List<Ingrediente> ingredientesTeste;
	private double totalCaloria;

	public Receita(String nomeReceita, String modoPreparo, java.util.List<Ingrediente> ingredientesTeste)
	{
		this.nomeReceita = nomeReceita;
		this.modoPreparo = modoPreparo;
		this.ingredientesTeste = ingredientesTeste;
		this.totalCaloria = totalCaloria;
	}

	public void setNomeReceita(String nomeReceita)
	{
	    nomeReceita = nomeReceita;
	}

	public String getNomeReceita()
	{
	    return nomeReceita;
	}

	public void setModoPreparo(String modoPreparo)
	{
	    modoPreparo = modoPreparo;
	}

	public String getModoPreparo()
	{
	    return modoPreparo;
	}

	public void setListaIngredinte(java.util.List<Ingrediente> ingredientesTeste)
	{
	    ingredientesTeste = ingredientesTeste;
	}

	public java.util.List<Ingrediente> getListaIngredinte()
	{
	    return ingredientesTeste;
	}

	public void setTotalCaloria(double totalCaloria)
	{
	    totalCaloria = totalCaloria;
	}

	public double getTotalCaloria()
	{
	    return totalCaloria;
	}
}