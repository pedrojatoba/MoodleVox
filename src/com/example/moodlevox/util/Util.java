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
                    c.setActualKey(1);
                } else if (compare(comando, "mensagem") || compare(comando,"2")) {
                    c.setMenu(2);
                    c.setActualKey(2);
                } else {
                    c.setMenu(0);
                    c.setTexto("Comando não reconhecido");
                }
                break;

            //Menu Disciplina, Opcoes: Java e Banco De Dados
            case 1:
                //c.setTexto("Acessada a disciplina " + comando);

                if (compare(comando, "voltar")) {
                    c.setMenu(0);
                    c.setActualKey(0);
                }else {
                    if (compare(comando, "Java") || compare(comando, "1")) {
                        c.setMenu(11);
                        c.setActualKey(11);
                    }//Para ser feito em demanda
                    else if (compare(comando, "banco de dados") || compare(comando, "2")) {
                        c.setMenu(12);
                        c.setTexto("Acessando a disciplina de Banco de Dados. Diga. após o sinal. qual comando deseja executar. 1. Fórum 2. Semanas.");
                    } else {
                        c.setMenu(1);
                        c.setTexto("Comando não reconhecido");
                    }
                }
                break;

                    //Menu disciplina Redes, Opcoes: Semanas, Forum
                    case 11:
                        //c.setTexto("Acessada a opção" + comando);
                        if (compare(comando, "voltar")) {
                            c.setMenu(1);
                            c.setActualKey(10);
                        } else {
                            if (compare(comando, "fórum") || compare(comando, "1")) {
                                c.setMenu(111);
                                c.setActualKey(111);
                            } else if (compare(comando, "semanas") || compare(comando, "2")) {
                                c.setMenu(112);
                                c.setActualKey(112);
                            } else {
                                c.setMenu(11);
                                c.setTexto("Comando não reconhecido");
                            }
                        }
                        break;

                            //Menu Disciplina Redes, Seccao Forum, Opcoes: Listar Foruns
                            case 111:
                                //c.setTexto("Executando Ação" + comando);
                                if (compare(comando, "voltar")) {
                                    c.setMenu(11);
                                    c.setActualKey(110);
                                } else {
                                    if (compare(comando, "listar fóruns") || compare(comando, "1")) {
                                        c.setMenu(1111);
                                        c.setActualKey(1111);
                                    } else {
                                        c.setMenu(111);
                                        c.setTexto("Comando não reconhecido");
                                    }
                                }
                                break;

                                    //Menu Disciplina Redes, Seccao Forum, Acao Listar Forum Problemas, opcoes listar postagens
                                    case 1111:
                                        if (compare(comando, "voltar")) {
                                            c.setMenu(111);
                                            c.setActualKey(1110);
                                        } else {
                                            if (compare(comando, "problemas")) {
                                                c.setMenu(11111);
                                                c.setActualKey(11111);
                                            } else if (compare(comando, "api") || compare(comando, "2")) {
                                                c.setMenu(11112);
                                                c.setActualKey(11112);
                                            } else {
                                                c.setMenu(1111);
                                                c.setTexto("Comando não reconhecido");
                                            }
                                        }

                                        break;

                                                    //Menu Disciplina Redes, Seccao Forum, Acao Listar Postagens de Problemas,opcoes postar
                                                    case 11111:
                                                        c.setTexto("As postagens do Fórum Problemas serão listadas");

                                                        if (compare(comando, "voltar")) {
                                                            c.setMenu(1111);
                                                            c.setActualKey(11110);
                                                        } else if (compare(comando, "postagem um")) {
                                                            c.setMenu(11111);
                                                            c.setTexto("A mensagem foi:" + (comando = PopulaPostagensProblemas(numeroPostagem)));
                                                            numeroPostagem = 1;
                                                        } else if (compare(comando, "postagem dois")) {
                                                            c.setMenu(11111);
                                                            c.setTexto("A mensagem foi:" + (comando = PopulaPostagensProblemas(numeroPostagem)));
                                                            numeroPostagem = 2;
                                                        } else if (compare(comando, "postar")) {
                                                            c.setMenu(111111);
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

                                                        if (compare(comando, "voltar")) {
                                                            c.setMenu(1111);
                                                            c.setActualKey(11110);
                                                        } else if (compare(comando, "postagem um")) {
                                                            c.setMenu(11111);
                                                            c.setTexto("A mensagem foi:" + (comando = PopulaPostagensIP(numeroPostagem)));
                                                            numeroPostagem = 1;
                                                        } else if (compare(comando, "postagem dois")) {
                                                            c.setMenu(11111);
                                                            c.setTexto("A mensagem foi:" + (comando = PopulaPostagensIP(numeroPostagem)));
                                                            numeroPostagem = 2;
                                                        } else if (compare(comando, "postar")) {
                                                            c.setMenu(111111);
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
                                if (compare(comando, "voltar")) {
                                    c.setMenu(11);
                                    c.setActualKey(110);
                                } else if (compare(comando, "Recursos")) {
                                    c.setMenu(1121);
                                    c.setActualKey(1121);
                                } else {
                                    c.setMenu(112);
                                    c.setTexto("Comando não reconhecido");
                                }

                                break;

                                    //Menu Disciplina Redes Seccao Semana, Acao Recursos, Opçoes Texto da semana, Links e Arquivos
                                    case 1121:
                                        if (compare(comando, "voltar")) {
                                            c.setMenu(112);
                                            c.setActualKey(1120);
                                        } else if (compare(comando, "texto da Semana")) {
                                            c.setMenu(11211);
                                            c.setActualKey(11211);
                                        } else if (compare(comando, "Links")) {
                                            c.setMenu(11212);
                                            c.setActualKey(11212);
                                        } else if (compare(comando, "Arquivos")) {
                                            c.setMenu(11213);
                                            c.setActualKey(11213);
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
                                                    c.setActualKey(11210);
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
                //okkkk
                if (compare(comando, "menu")) {
                    c.setMenu(0);
                    c.setActualKey(0);
                } else {
                    //okkkk
                    if (compare(comando, "ler")) {
                        c.setActualKey(21);
                        c.setMenu(21);
                    }
                    //ok
                    else if (compare(comando, "escrever")) {
                        c.setActualKey(22);
                        c.setMenu(22);
                    }
                    //okkkk
                    else if (compare(comando, "repetir")) {
                        c.setActualKey(222);
                        c.setMenu(2);
                    }
                    //okkkk
                    else {
                        c.setMenu(2);
                        c.setActualKey(101);
                    }
                }
                break;

            // leitura
            case 21:
                //okkkk
                if (compare(comando, "menu")) {
                    c.setMenu(0);
                    c.setActualKey(0);
                }
                //ok
                else {
                    //OKkkk
                    if (compare(comando, "sim")) {
                        c.setActualKey(210);
                        c.setMenu(211);
                    }

                    //OKkkkk
                    else if (compare(comando, "não")) {
                        c.setMenu(2);
                        c.setActualKey(2);
                    }

                    //OKkkkk
                    else if (compare(comando, "voltar")) {
                        c.setMenu(2);
                        c.setActualKey(20);
                    }
                    //okkkkkk
                    else if (compare(comando, "repetir")) {

                        c.setActualKey(2201);
                        c.setMenu(21);
                    }
                    //okkk
                    else {
                        c.setMenu(21);
                        c.setActualKey(101);
                    }
                }
                break;

            // responder
            case 211:
                //okkkk
                if (compare(comando, "menu")) {
                    c.setMenu(0);
                    c.setActualKey(0);
                }
                else{
                    //OKkkk
                    if (compare(comando, "sim")) {
                        c.setActualKey(2110);
                        c.setMenu(2111);
                    }
                    //OKkkkk
                    else if (compare(comando, "não")) {
                        c.setMenu(2);
                        c.setActualKey(2);
                    }
                    //okkkkk
                    else if (compare(comando, "voltar")) {
                        c.setMenu(21);
                        c.setActualKey(220);
                    }
                    //okkkk
                    else if (compare(comando, "repetir")) {

                        c.setActualKey(22011);
                        c.setMenu(211);
                    }
                    //okkk
                    else {
                    	c.setActualKey(101);
                        c.setMenu(211);

                    }
                }
                break;

            case 2111:
                //okkkk
                c.setActualKey(21100);
                //volta pro menu 2 mas não avisa pro usuário
                c.setMenu(2);
                break;



            case 22:// buscar o destinatario informado

                if (compare(comando, "menu")) {
                    c.setMenu(0);
                    c.setActualKey(0);
                }
                else{

                    
                    contatosBuscados = new HashMap<String, String>();

                    String[] contatos = { "Alana Luna", "Alana Aguiar",
                            "Alana Oliveira", "Pedro Jatobá", "Yuri", "Jhonathan" };

                    c.setActualKey(2222); 
                     //String texto = "Contatos encontrados: ";
//
                    for (int i = 0, j = 1; i < contatos.length; i++) {
                        // SE O CONTATO ARMAZENADO FOR IGUAL AO COMANDO DO USUÁRIO
                        // O ARRAYLIST CONTATOSBUSCADOS RECEBE O CONTATO QUE FOI
                        // EQUIVALENTE AO COMANDO

                        if (compare(contatos[i], comando)) {
                            contatosBuscados.put(""+j, contatos[i]);
                             
                              //texto += j + " " + contatos[i];
                            j++;
                            // break;
                        }
                    }

                    if (contatosBuscados.size() > 0) {
//                        texto += " Após o sinal, diga o numero do contato que deseja enviar a mensagem.";
                        c.setActualKey(22221); 
                          //c.setTexto(texto);
                        c.setMenu(221);
                    }
                    //ok
                    else if (compare(comando, "voltar")) {
                        c.setMenu(2);
                        c.setActualKey(20);
                    }
//                    //não precisa repetir porque ele precisa do nome do destinatário do case 2, então o repetir seria o mesmo que voltar
//
                    //ok
                    else {
                        c.setActualKey(22222); 
                          //c.setTexto("Contato não encontrado. Favor repetir.");
                        c.setMenu(22);
                    }
                }
                break;

            case 221:
                //ok
                if (validarNumero(comando)) {
//                    String texto1 = "Enviando mensagem para "
//                            + contatosBuscados.get(comando)
//                            + " . Fale o texto de sua mensagem";
//                    c.setTexto(texto1);
                
                    c.setActualKey(22223);
                    c.setMenu(2211);
                }


                //ok
                else {
                    c.setActualKey(101);
                    c.setMenu(221);
                }

                break;

            case 2211:
                //ok
                c.setActualKey(21100);
                c.setMenu(2);
                break;

            default:
                //ok
                c.setMenu(0);
                c.setActualKey(101);
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

