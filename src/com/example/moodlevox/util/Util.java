package com.example.moodlevox.util;

import com.example.moodlevox.entidades.Comandos;
import java.util.ArrayList;
import java.util.HashMap;

public class Util {

    private static HashMap<String, String> contatosBuscados;

    public static String PopulaPostagensProblemas(int numeroPostagem){
        ArrayList<String> postagens = new ArrayList(10);

        postagens.set(0, "Fulano perguntou : Qual o problema?");
        postagens.set(1, "Ciclano Respondeu: Todos");
        return postagens.get(numeroPostagem);
    }
    public static String PopulaPostagensIP(int numeroPostagem){
        ArrayList<String> postagens = new ArrayList(10);

        postagens.set(0, "Fulano perguntou : Qual o IP?");
        postagens.set(1, "Ciclano Respondeu: 192.168.101.94");
        return postagens.get(numeroPostagem);
    }

    public static Comandos Acao(int menu, String comando) {

        Comandos c = new Comandos();
        int numeroPostagem = 0;

        switch (menu) {
            case 0:
                //fazer um equals melhor
                if (compare(comando, "disciplina") || compare(comando, "1")) {
                    c.setMenu(1);
                    c.setMenuAnterior(0);
                    // buscar as disciplinas correntes do usuario e colocar no texto
                    c.setTexto("As disciplinas atuais são: 1 Java, 2 Banco De Dados. Qual disciplina deseja acessar?");
                    c.setTextoAnterior("Bem vindo ao Teste do Moodle Voz. Diga qual comando você deseja executar. 1 Disciplinas ou 2 Mensaegens");
                } else if (compare(comando, "mensagens") || compare(comando,"2")) {
                    c.setMenu(2);
                    c.setTexto("Acesso ao menu de mensagens, qual o comando desejado?");
                } else {
                    c.setMenu(0);
                    c.setTexto("Comando não reconhecido");
                }
                break;

            //Menu Disciplina, Opcoes: Java e Banco De Dados
            case 1:
                c.setTexto("Acessada a disciplina " + comando);

                if (compare(comando, "voltar")) {
                    c.setMenu(c.getMenuAnterior());
                    c.setTexto("Voltando para o menu anterior");
                }else {
                    if (compare(comando, "java") || compare(comando, "1")) {
                        c.setMenu(11);
                        c.setTexto("As secções atuais são: 1. Semanas, 2. Fórum. Que secção da disciplina de Java você deseja acessar?");
                    } else if (compare(comando, "banco de dados") || compare(comando,"2")) {
                        c.setMenu(12);
                        c.setTexto("As secçoes atuais são: 1. Aulas, 2. Forum. Que secçao da disciplina de Banco de Dados voce deseja acessar?");
                    } else {
                        c.setMenu(1);
                        c.setTexto("Comando não reconhecido");
                    }
                }
                break;

                    //Menu disciplina Redes, Opcoes: Semanas, Forum
                    case 11:
                        c.setTexto("Acessada a opção" + comando);
                        if (compare(comando, "fórum")) {
                            c.setMenu(111);
                            c.setTexto("As opções atuais são: Listar Fóruns");
                        } else if (compare(comando, "semanas")) {
                            c.setMenu(112);
                            c.setTexto("As acoes atuais sao: Recursos");
                        } else if (compare(comando, "voltar")) {
                            c.setMenu(1);
                            c.setTexto("Voltando para o menu anterior");
                        } else {
                            c.setMenu(11);
                            c.setTexto("Comando não reconhecido");
                        }

                        break;

                            //Menu Disciplina Redes, Seccao Forum, Opcoes: Listar Foruns
                            case 111:
                                c.setTexto("Executando Ação" + comando);
                                if (compare(comando, "listar")) {
                                    c.setMenu(1111);
                                    c.setTexto("Os Fóruns disponíveis são: 1 Problemas, e 2 API");
                                } else if (compare(comando, "voltar")) {
                                    c.setMenu(11);
                                    c.setTexto("Voltando para o menu anterior");
                                } else {
                                    c.setMenu(111);
                                    c.setTexto("Comando não reconhecido");
                                }

                                break;

                                    //Menu Disciplina Redes, Seccao Forum, Acao Listar Forum Problemas, opcoes listar postagens
                                    case 1111:
                                        c.setTexto("Você está no Fórum " + comando + ". Deseja listar todas as postagens? Ou alguma específica?");
                                        if (compare(comando, "problemas")) {
                                            c.setMenu(11111);
                                        } else if (compare(comando, "api") || compare(comando, "2")) {
                                            c.setMenu(11112);
                                        } else if (compare(comando, "voltar")) {
                                            c.setMenu(111);
                                            c.setTexto("Voltando para o menu anterior");
                                        } else {
                                            c.setMenu(1111);
                                            c.setTexto("Comando não reconhecido");
                                        }

                                        break;

                                                    //Menu Disciplina Redes, Seccao Forum, Acao Listar Postagens de Problemas,opcoes postar
                                                    case 11111:
                                                        c.setTexto("As postagens do Fórum Problemas serão listadas");

                                                        if (compare(comando, "postar")) {
                                                            c.setMenu(111111);
                                                        } else if (compare(comando, "postagem um")) {
                                                            c.setMenu(11111);
                                                            c.setTexto("A mensagem foi:" + (comando = PopulaPostagensProblemas(numeroPostagem)));
                                                            numeroPostagem = 1;
                                                        } else if (compare(comando, "postagem dois")) {
                                                            c.setMenu(11111);
                                                            c.setTexto("A mensagem foi:" + (comando = PopulaPostagensProblemas(numeroPostagem)));
                                                            numeroPostagem = 2;
                                                        } else if (compare(comando, "voltar")) {
                                                            c.setMenu(1111);
                                                            c.setTexto("voltando para o menu anterior");
                                                        } else {
                                                            c.setMenu(11111);
                                                            c.setTexto("Comando não reconhecido");
                                                        }


                                                        break;

                                                            //Menu Disciplina Redes, Seccao Forum, Acao Postar
                                                            case 111111:
                                                                c.setTexto("Sua Postagem " + comando + ". Foi Postada com Sucesso");
                                                                c.setMenu(111);

                                                                break;


                                                    //Menu Disciplina Redes, Seccao Forum, Acao Listar Postagens de IP,opcoes postar
                                                    //Menu Disciplina Redes, Seccao Forum, Acao Listar Postagens de Problemas,opcoes postar
                                                    case 11112:
                                                        c.setTexto("As postagens do Fórum IP serão listadas");

                                                        if (compare(comando, "postar")) {
                                                            c.setMenu(111111);
                                                        } else if (compare(comando, "postagem um")) {
                                                            c.setMenu(11111);
                                                            c.setTexto("A mensagem foi:" + (comando = PopulaPostagensIP(numeroPostagem)));
                                                            numeroPostagem = 1;
                                                        } else if (compare(comando, "postagem dois")) {
                                                            c.setMenu(11111);
                                                            c.setTexto("A mensagem foi:" + (comando = PopulaPostagensIP(numeroPostagem)));
                                                            numeroPostagem = 2;
                                                        } else if (compare(comando, "voltar")) {
                                                            c.setMenu(1111);
                                                            c.setTexto("voltando para o menu anterior");
                                                        } else {
                                                            c.setMenu(11111);
                                                            c.setTexto("Comando não reconhecido");
                                                        }

                                                        break;

                                                            //Menu Disciplina Redes, Seccao Forum, Acao Postar
                                                            case 111121:
                                                                c.setTexto("Sua Postagem" + comando + "Foi Postada com Sucesso");
                                                                c.setMenu(111);

                                                                break;


                            //Menu Disciplina Redes, Seccao Semana, Opcoes: Recursos
                            case 112:
                                c.setTexto("Executando Acao" + comando);
                                if (compare(comando, "Recursos")) {
                                    c.setMenu(1121);
                                    c.setTexto("Recursos são: Texto da semana, Links e Arquivos");
                                } else if (compare(comando, "voltar")) {
                                    c.setMenu(11);
                                    c.setTexto("Voltando para o menu anterior");
                                } else {
                                    c.setMenu(112);
                                    c.setTexto("Comando não reconhecido");
                                }

                                break;

                                    //Menu Disciplina Redes Seccao Semana, Acao Recursos, Opçoes Texto da semana, Links e Arquivos
                                    case 1121:
                                        c.setTexto("Entrando em " + comando);
                                        if (compare(comando, "Texto da Semana")) {
                                            c.setMenu(11211);
                                            c.setTexto("entrando em " + comando);
                                        } else if (compare(comando, "Links")) {
                                            c.setMenu(11212);
                                            c.setTexto("entrando em " + comando);
                                        } else if (compare(comando, "Arquivos")) {
                                            c.setMenu(11213);
                                            c.setTexto("entrando em " + comando);
                                        } else if (compare(comando, "voltar")) {
                                            c.setMenu(112);
                                            c.setTexto("Voltando para o menu anterior");
                                        } else {
                                            c.setMenu(1121);
                                            c.setTexto("Comando não reconhecido");
                                        }

                                        break;

                                            //Menu Disciplina Redes, Seccao Semana, Acao Recursos, Opçao Texto da semana
                                            case 11211:
                                                c.setTexto("O texto da semana é");
                                                if (compare(comando, "voltar")) {
                                                    c.setMenu(1121);
                                                    c.setTexto("Voltando para o menu anterior");
                                                } else {
                                                    c.setMenu(1121);
                                                    c.setTexto("Comando não reconhecido");
                                                }
                                                break;

                                            //Menu Disciplina Redes, Seccao Semana, Acao Recursos, Opçao Links
                                            case 11212:
                                                c.setTexto("Os links são");
                                                if (compare(comando, "voltar")) {
                                                    c.setMenu(1121);
                                                    c.setTexto("Voltando para o menu anterior");
                                                } else {
                                                    c.setMenu(1121);
                                                    c.setTexto("Comando não reconhecido");
                                                }
                                                break;


                                            //Menu Disciplina Redes, Seccao Semana, Acao Recursos, Opçao Arquivos
                                            case 11213:
                                                c.setTexto("os Arquivos são:");
                                                if (compare(comando, "voltar")) {
                                                    c.setMenu(1121);
                                                    c.setTexto("Voltando para o menu anterior");
                                                } else {
                                                    c.setMenu(1121);
                                                    c.setTexto("Comando não reconhecido");
                                                }
                                                break;

            // MENSAGENS
            case 2:
                if (compare(comando, "voltar")) {
                    c.setMenu(0);
                    c.setTexto("Acesso ao menu inicial, diga qual comando você deseja executar");
                } else {

                    if (compare(comando, "leitura")) {
                        c.setTexto("Acessando menu de leitura. Nova mensagem de Fulano De Tal. O que deseja fazer?");
                        c.setMenu(21);
                    } else if (compare(comando, "escrever")) {
                        c.setTexto("Informe o destinatário");
                        c.setMenu(22);

                    } else {
                        c.setMenu(2);
                        c.setTexto("Comando não reconhecido. Favor repetir.");
                    }
                }
                break;

            // leitura
            case 21:
                if (compare(comando, "voltar")) {
                    c.setMenu(2);
                    c.setTexto("Acesso ao menu de mensagens, qual o comando desejado?");
                } else {
                    if (compare(comando, "abrir")) {
                        c.setTexto("Mensagem de Fulano De Tal: Oi tudo bem?. Deseja responder?");
                        c.setMenu(211);
                    } else {
                        c.setMenu(21);
                        c.setTexto("Comando não reconhecido. Favor repetir.");
                    }
                }
                break;

            // responder
            case 211:
                if (compare(comando, "sim")) {
                    c.setTexto("Fale a mensagem de resposta");
                    c.setMenu(2111);
                } else {
                    c.setTexto("Comando não reconhecido. Favor repetir");
                    c.setMenu(211);

                }
                break;

            case 2111:
                c.setTexto("Mensagem enviada com sucesso");
                c.setMenu(2);
                break;

            case 22:// buscar o destinatario informado
                contatosBuscados = new HashMap<String, String>();

                String[] contatos = { "Alana Luna", "Alana Aguiar",
                        "Alana Oliveira", "Pedro Jatobá", "Yuri", "Jhonathan" };

                String texto = "Contatos encontrados: ";

                for (int i = 0, j = 1; i < contatos.length; i++) {
                    // SE O CONTATO ARMAZENADO FOR IGUAL AO COMANDO DO USUÁRIO
                    // O ARRAYLIST CONTATOSBUSCADOS RECEBE O CONTATO QUE FOI
                    // EQUIVALENTE AO COMANDO

                    if (compare(contatos[i], comando)) {
                        contatosBuscados
                                .put(""+j, contatos[i]);
                        texto += j + " " + contatos[i];
                        j++;
                        // break;
                    }
                }

                if (contatosBuscados.size() > 0) {
                    texto += "Diga o numero do contato que deseja enviar a mensagem.";
                    c.setTexto(texto);
                    c.setMenu(221);
                } else {
                    c.setTexto("Contato não encontrado. Favor repetir.");
                    c.setMenu(22);
                }

                break;

            case 221:

                if (validarNumero(comando)) {
                    String texto1 = "Enviando mensagem para "
                            + contatosBuscados.get(comando)
                            + " . Fale o texto de sua mensagem";

                    c.setTexto(texto1);
                    c.setMenu(2211);
                } else {
                    c.setTexto("Comando não reconhecido. Favor repetir");
                    c.setMenu(221);
                }

                break;

            case 2211:
                c.setTexto("Mensagem enviada com sucesso");
                c.setMenu(2);
                break;

            default:
                c.setMenu(0);
                c.setTexto("Comando não reconhecido. Favor repetir");
                break;
        }

        return c;
    }

    private static boolean validarNumero(String s) {
        return contatosBuscados.containsKey(s);
    }

    public static boolean compare(String a, String b) {
        boolean resp = false;

        char[] correto = b.toCharArray();
        char[] testado = a.toCharArray();

        int acertos = 0;

        for (int i = 0; i < correto.length && i < testado.length; i++) {
            if (correto[i] == testado[i]) {
                acertos++;
            }
        }
//<60?
        resp = (((double) acertos / correto.length) * 100) > 75 ? true : false;

        return resp;
    }
}
