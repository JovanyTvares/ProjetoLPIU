/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpiu.arquivos.associacao;

import br.cesjf.lpiu.modelo.Associacao;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tassio
 */
public class ArquivoInAssociacao {
    
    private FileInputStream fin = null;
    private ObjectInputStream objIn = null;
    
    public void abrir() throws FileNotFoundException, IOException {
        fin = new FileInputStream("informacoes_associacao.txt");
        objIn = new ObjectInputStream(fin);
    }
    
    public void fechar() {
        try {
            objIn.close();
            fin.close();
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInAssociacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Associacao getAssociacao() throws IOException, ClassNotFoundException {
         Associacao associacao = new Associacao();

        try {
            associacao = (Associacao) objIn.readObject();
        } catch (EOFException ex) {
            associacao = null;
        }
        return associacao;
    }
    
    public List getTodasAssociacoes() {
        List<Associacao> lista = new ArrayList<Associacao>();

        try {
            this.abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoInAssociacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInAssociacao.class.getName()).log(Level.SEVERE, null, ex);
        }


        boolean continua = true;
        Associacao associacao = null;
        while (continua) {
            try {
                associacao = (Associacao) objIn.readObject();
                lista.add(associacao);
            } catch (EOFException ex) {
                continua = false;
            } catch (IOException ex) {
                continua = false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArquivoInAssociacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fechar();
        return lista;
    }
    
}
