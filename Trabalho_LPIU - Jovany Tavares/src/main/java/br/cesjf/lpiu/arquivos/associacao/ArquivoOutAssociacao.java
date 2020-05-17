/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpiu.arquivos.associacao;

import br.cesjf.lpiu.modelo.Associacao;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tassio
 */
public class ArquivoOutAssociacao {
    
    private FileOutputStream fout = null;
    private ObjectOutputStream objOut = null;
    private List<Associacao> lista = new ArrayList<Associacao>();
    
    public void abrir() throws FileNotFoundException, IOException { //throws, trata exceção para cada coisa que possa acontecer
        preparar();
        fout = new FileOutputStream("informacoes_associacao.txt");
        objOut = new ObjectOutputStream(fout);
        for (int i = 0; i < lista.size(); i++) {
            objOut.writeObject(lista.get(i));
        }
    }
    
    private void preparar() {
        ArquivoInAssociacao arq = new ArquivoInAssociacao();
        try {
            arq.abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoOutAssociacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoOutAssociacao.class.getName()).log(Level.SEVERE, null, ex);
        }


        boolean continua = true;
        Associacao associacao = null;
        while (continua) {
            try {
                associacao = arq.getAssociacao();
                if (associacao != null) {
                    lista.add(associacao);
                } else {
                    continua = false;
                }
            } catch (EOFException ex) {
                continua = false;
            } catch (IOException ex) {
                Logger.getLogger(ArquivoOutAssociacao.class.getName()).log(Level.SEVERE, null, ex);
                continua = false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArquivoOutAssociacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        arq.fechar();
    }
    
    public void fechar() throws IOException {//throws, trata a exceção IOException
        objOut.close();
        fout.close();
    }
    
    public void Adicionar(Associacao associacao) throws IOException {
        objOut.writeObject(associacao);//grava o objeto todo
    }

    public void recadastrar_todas(ArrayList<Associacao> lista2) throws IOException {
        fout = new FileOutputStream("informacoes_associacao.txt");
        objOut = new ObjectOutputStream(fout);

        for (int i = 0; i < lista2.size(); i++) {
            objOut.writeObject(lista2.get(i));
        }
    }
    
}
