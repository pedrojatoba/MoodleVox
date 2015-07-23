package com.example.moodlevox.entidades;

import java.util.Dictionary;
import java.util.HashMap;

public class Comandos {

    private HashMap<Integer, String> audios = new HashMap<Integer, String>();
    private int menu, actualKey;
    private String texto;

    public Comandos() {
        //Audios de Entrada
        audios.put(1, "As disciplinas atuais são: 1 Java, 2 Banco De Dados. Diga. após o sinal. Qual disciplina deseja acessar.");
        audios.put(11, "Acessando a disciplina de Java. Diga. após o sinal. qual comando deseja executar. 1. Fórum. 2. Semanas.");
        audios.put(111, "Acessando o menu de Fóruns. Diga. após o sinal. Qual comando deseja executar. 1. Listar Fóruns");
        audios.put(1111, "Você esta no menu de fóruns listados. Os Fóruns disponíveis são: 1 Problemas, e 2 API");
        audios.put(11111, "Você está no Fórum Problemas Para listar postagens diga: Postagens ou 1 ");
        audios.put(11112, "Você está no Fórum API Para listar postagens diga: Postagens ou 1 ");
        audios.put(112, "Acessando o menu de Semanas. Diga. após o sinal. Qual comando deseja executar. 1. Recursos");
        audios.put(1121, "Acessando  menu de Recursos, eles são: 1. Texto da semana, 2. Links e 3. Arquivos");
        audios.put(11211, "Acessando o texto da semana");
        audios.put(11212, "Os links da semana serão apresentados");
        audios.put(11213, "As opções de arquivos para download ou vizualização são:");
        audios.put(2, "Acesso ao menu de mensagens, qual o comando desejado?");
        //Audios de Retorno\
        audios.put(0, "Voltando para ao menu inicial do Moodle Voz. Diga. após o sinal. qual comando você deseja executar. 1. Disciplinas. 2. Mensagens.");
        audios.put(10, "Voltando ao menu de disciplinas. As disciplinas atuais são: 1 Java, 2 Banco De Dados. Diga. após o sinal. Qual disciplina deseja acessar.");
        audios.put(110, "Vontando ao meun da diciplina Java. Diga. após o sinal. qual comando deseja executar. 1. Fórum 2. Semanas.");
        audios.put(1110, "Voltando para o menu de Fóruns. Diga. após o sinal. Qual comando deseja executar. 1. Listar Fóruns");
        audios.put(11110, "Voltando para o menu de fóruns listados. Os Fóruns disponíveis são: 1 Problemas, e 2 API");
        audios.put(111110, "Voltando para o Fórum Problemas Para listar postagens diga: Postagens ou 1 ");
        audios.put(111120, "Voltando para o Fórum API Para listar postagens diga: Postagens ou 1 ");
        audios.put(1120, "Voltando para o menu de Semanas. Diga. após o sinal. Qual comando deseja executar. 1. Recursos");
        audios.put(11210, "Voltando para o menu de recursos são: 1. Texto da semana, 2. Links e 3. Arquivos");
    }

	public Comandos(int menu, String texto) {
		this.menu = menu;

    }

	public int getMenu() {
		return menu;
	}

    public void setMenu(int menu) {
        this.menu = menu;
    }

    public String getTexto() {
        return audios.get(actualKey);
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getActualKey() {
        return this.actualKey;
    }

    public void setActualKey(int value) {
        this.actualKey = value;
    }


}
