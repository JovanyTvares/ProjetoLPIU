/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpiu.arquivos.associacao;

import br.cesjf.lpiu.modelo.Pessoas;
import br.cesjf.lpiu.modelo.Automovel;
import br.cesjf.lpiu.modelo.Associacao;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author tassio
 */
public class CreatedFileAssociacao {
    
    /**
        * @param args
        * @throws
        */
       public static void main(String[] args) {
             try {
                    FileOutputStream fout = new FileOutputStream("informacoes_associacao.txt");
                    ObjectOutputStream objOut = new ObjectOutputStream(fout);
        
                    Pessoas pessoa = new Pessoas();
                    pessoa.setCnh("79222160069");
                    Automovel automovel = new Automovel();
                    automovel.setPlaca("ABC-1D34");
                    Associacao associacao = new Associacao();
                    associacao.setCnhCondutor(pessoa.getCnh());
                    associacao.setPlacaVeiculo(automovel.getPlaca());                 
                    
                    objOut.writeObject(associacao);
                                 
                    objOut.close();
                    
             } catch (IOException e) {
                    e.printStackTrace();
             }
  
       }
    
}
