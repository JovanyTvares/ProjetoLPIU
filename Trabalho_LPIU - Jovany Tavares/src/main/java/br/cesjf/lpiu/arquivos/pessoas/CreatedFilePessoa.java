/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpiu.arquivos.pessoas;

import br.cesjf.lpiu.modelo.Pessoas;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Jovany
 */
public class CreatedFilePessoa {
    
    /**
        * @param args
        * @throws
        */
       public static void main(String[] args) {
             try {
                    FileOutputStream fout = new FileOutputStream("informacoes_pessoas.txt");
                    ObjectOutputStream objOut = new ObjectOutputStream(fout);
        
                    Pessoas pessoa = new Pessoas();
                    pessoa.setNome("Roberto Da Silva");
                    pessoa.setDataNascimento("17-08-1996");
                    pessoa.setCnh("87058666540");
                    pessoa.setEndereco("Quadra 39");
                    pessoa.setBairro("Renascença");
                    pessoa.setNumero("1-A");
                    pessoa.setComplemento("Fundos");
                    pessoa.setCidade("Teresina");
                    pessoa.setEstado("Pi");
                    pessoa.setCep("36.082-554");
                              
                    objOut.writeObject(pessoa);
                   
                    objOut.close();
             } catch (IOException e) {
                    e.printStackTrace();
             }
  
       }
    
}
