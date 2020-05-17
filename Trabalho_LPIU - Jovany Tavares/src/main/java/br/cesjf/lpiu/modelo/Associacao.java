/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpiu.modelo;

import java.io.Serializable;

/**
 *
 * @author Jovany
 */
public class Associacao implements Serializable {
    public String placaVeiculo;
    public String cnhCondutor;

    public Associacao() {
    }

    public Associacao(String placaVeiculo, String cnhCondutor) {
        this.placaVeiculo = placaVeiculo;
        this.cnhCondutor = cnhCondutor;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getCnhCondutor() {
        return cnhCondutor;
    }

    public void setCnhCondutor(String cnhCondutor) {
        this.cnhCondutor = cnhCondutor;
    }

    @Override
    public String toString() {
        return "Associacao{" + "placaVeiculo=" + placaVeiculo + ", cnhCondutor=" + cnhCondutor + '}';
    }
    
    public Object[] getAssociacao() {
        Object associacao[] = {placaVeiculo, cnhCondutor};
        return associacao;
    }
            
}
