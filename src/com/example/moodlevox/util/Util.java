package com.example.moodlevox.util;

import com.example.moodlevox.entidades.Comandos;
import java.util.ArrayList;
import java.util.HashMap;

public class Util {

    private static HashMap<String, String> contatosBuscados;

    public static Comandos Acao(int menu, String comando) {

        Comandos c = new Comandos();
        int numeroPostagem = 0;

        switch (menu) {
            case 0:
                //fazer um equals melhor
                if (compare(comando, "disciplina") || compare(comando, "1")) {
                    c.setMenu(1);
                    c.setActualKey(1);
                } else if (compare(comando, "mensagens") || compare(comando,"2")) {
                    c.setMenu(2);
                    c.setActualKey(2);
                } else if (compare(comando, "repetir")) {
                    c.setMenu(0);
                    c.setActualKey(1001);
                } else {
                    c.setMenu(0);
                    c.setActualKey(101);
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
                    /*else if (compare(comando, "banco de dados") || compare(comando, "2")) {
                        c.setMenu(12);
                        //c.setTexto("Acessando a disciplina de Banco de Dados. Diga. após o sinal. qual comando deseja executar. 1. Fórum 2. Semanas.");
                    }*/
                    else if (compare(comando, "repetir")) {
                        c.setMenu(1);
                        c.setActualKey(1);
                    } else {
                        c.setMenu(1);
                        c.setActualKey(101);
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
                            } else if (compare(comando, "repetir")) {
                                c.setMenu(11);
                                c.setActualKey(11);
                            } else {
                                c.setMenu(11);
                                c.setActualKey(101);
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
                                    if (compare(comando, "listar") || compare(comando, "1")) {
                                        c.setMenu(1111);
                                        c.setActualKey(1111);
                                    } else if (compare(comando, "repetir")) {
                                        c.setMenu(111);
                                        c.setActualKey(111);
                                    } else {
                                        c.setMenu(111);
                                        c.setActualKey(101);
                                    }
                                }
                                break;

                                    //Menu Disciplina Redes, Seccao Forum, Acao Listar Forum Problemas, opcoes listar postagens
                                    case 1111:
                                        if (compare(comando, "voltar")) {
                                            c.setMenu(111);
                                            c.setActualKey(1110);
                                        } else {
                                            if (compare(comando, "problemas") || compare(comando, "1")) {
                                                c.setMenu(11111);
                                                c.setActualKey(11111);
                                            } else if (compare(comando, "api") || compare(comando, "2")) {
                                                c.setMenu(11112);
                                                c.setActualKey(11112);
                                            } else if (compare(comando, "repetir")) {
                                                c.setMenu(1111);
                                                c.setActualKey(1111);
                                            } else {
                                                c.setMenu(1111);
                                                c.setActualKey(101);
                                            }
                                        }

                                        break;

                                                    //Menu Disciplina Redes, Seccao Forum, Acao Listar Postagens de Problemas,opcoes postar
                                                    case 11111:

                                                        if (compare(comando, "voltar")) {
                                                            c.setMenu(1111);
                                                            c.setActualKey(11110);
                                                        } else if (compare(comando, "postagem um")) {
                                                            c.setMenu(11111);
                                                        } else if (compare(comando, "postagem dois")) {
                                                            c.setMenu(11111);
                                                        } else if (compare(comando, "postar")) {
                                                            c.setMenu(111111);
                                                        } else if (compare(comando, "repetir")) {
                                                            c.setMenu(11111);
                                                            c.setActualKey(11111);
                                                        } else {
                                                            c.setMenu(11111);
                                                            c.setActualKey(101);
                                                        }


                                                        break;

                                                            //Menu Disciplina Redes, Seccao Forum, Acao Postar
                                                            case 111111:
                                                                //modificar com set actual key
                                                                //c.setTexto("Sua Postagem " + comando + ". Foi Postada com Sucesso");
                                                                c.setMenu(111);

                                                                break;


                                                    //Menu Disciplina Redes, Seccao Forum, Acao Listar Postagens de IP,opcoes postar
                                                    //Menu Disciplina Redes, Seccao Forum, Acao Listar Postagens de Problemas,opcoes postar
                                                    case 11112:

                                                        if (compare(comando, "voltar")) {
                                                            c.setMenu(1111);
                                                            c.setActualKey(11110);
                                                        } else if (compare(comando, "postagem um")) {
                                                            c.setMenu(11111);
                                                        } else if (compare(comando, "postagem dois")) {
                                                            c.setMenu(11111);
                                                        } else if (compare(comando, "postar")) {
                                                            c.setMenu(111121);
                                                        } else if (compare(comando, "repetir")) {
                                                            c.setMenu(11112);
                                                            c.setActualKey(11112);
                                                        } else {
                                                            c.setMenu(11111);
                                                            c.setActualKey(101);
                                                        }

                                                        break;

                                                            //Menu Disciplina Redes, Seccao Forum, Acao Postar
                                                            case 111121:
                                                                //modificar com o set actual key
                                                                //c.setTexto("Sua Postagem" + comando + "Foi Postada com Sucesso");
                                                                c.setMenu(111);

                                                                break;


                            //Menu Disciplina Redes, Seccao Semana, Opcoes: Recursos
                            case 112:
                                if (compare(comando, "voltar")) {
                                    c.setMenu(11);
                                    c.setActualKey(110);
                                } else if (compare(comando, "Recursos") || compare(comando, "1")) {
                                    c.setMenu(1121);
                                    c.setActualKey(1121);
                                } else if (compare(comando, "repetir")) {
                                    c.setMenu(112);
                                    c.setActualKey(112);
                                } else {
                                    c.setMenu(112);
                                    c.setActualKey(101);
                                }

                                break;

                                    //Menu Disciplina Redes Seccao Semana, Acao Recursos, Opçoes Texto da semana, Links e Arquivos
                                    case 1121:
                                        if (compare(comando, "voltar")) {
                                            c.setMenu(112);
                                            c.setActualKey(1120);
                                        } else if (compare(comando, "texto") || compare(comando, "1")) {
                                            c.setMenu(11211);
                                            c.setActualKey(11211);
                                        } else if (compare(comando, "Links") || compare(comando, "2")) {
                                            c.setMenu(11212);
                                            c.setActualKey(11212);
                                        } else if (compare(comando, "Arquivos") || compare(comando, "3")) {
                                            c.setMenu(11213);
                                            c.setActualKey(11213);
                                        } else if (compare(comando, "repetir")) {
                                            c.setMenu(1121);
                                            c.setActualKey(1121);
                                        } else {
                                            c.setMenu(1121);
                                            c.setActualKey(101);
                                        }

                                        break;

                                            //Menu Disciplina Redes, Seccao Semana, Acao Recursos, Opçao Texto da semana
                                            case 11211:
                                                if (compare(comando, "voltar")) {
                                                    c.setMenu(1121);
                                                    c.setActualKey(11210);
                                                } else if (compare(comando, "repetir")) {
                                                    c.setMenu(11211);
                                                    c.setActualKey(11211);
                                                } else {
                                                    c.setMenu(11211);
                                                    c.setActualKey(101);
                                                }
                                                break;

                                            //Menu Disciplina Redes, Seccao Semana, Acao Recursos, Opçao Links
                                            case 11212:
                                                if (compare(comando, "voltar")) {
                                                    c.setMenu(1121);
                                                    c.setActualKey(11210);
                                                } else if (compare(comando, "repetir")) {
                                                    c.setMenu(11212);
                                                    c.setActualKey(11212);
                                                } else {
                                                    c.setMenu(11212);
                                                    c.setActualKey(101);
                                                }
                                                break;


                                            //Menu Disciplina Redes, Seccao Semana, Acao Recursos, Opçao Arquivos
                                            case 11213:
                                                if (compare(comando, "voltar")) {
                                                    c.setMenu(1121);
                                                    c.setActualKey(11210);
                                                } else if (compare(comando, "repetir")) {
                                                    c.setMenu(11213);
                                                    c.setActualKey(11213);
                                                } else {
                                                    c.setMenu(11213);
                                                    c.setActualKey(101);
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
        resp = (((double) acertos / correto.length) * 100) >= 75 ? true : false;

        return resp;
    }
}
