package com.example.moodlevox.entidades;

public class Comandos {

	private int menu, menuAnterior;
	private String texto, textoAnterior;

	public Comandos(){}
	
	public Comandos(int menu, String texto) {
		this.menu = menu;
        this.menuAnterior = menu;
		this.texto = texto;
        this.textoAnterior = texto;
	}

	public int getMenu() {
		return menu;
	}
    public int getMenuAnterior() {
        return menuAnterior;
    }

    public String getTexto() {
        return texto;
    }
    public String getTextoAnterior() {
        return textoAnterior;
    }

    public void setMenu(int menu) {
		this.menu = menu;
	}
    public void setMenuAnterior(int menu) {this.menuAnterior = menu;}



	public void setTexto(String texto) {
		this.texto = texto;
	}
    public void setTextoAnterior(String texto) {
        this.textoAnterior = texto;
    }

}
