/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetoMave.beans;

import br.projetoMave.interfaces.BeasnInteface;
import br.projetoMave.model.Uf;
import br.projetoMave.service.UfService;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author tibe
 */
@Named
@ViewScoped
public class UfBeans implements Serializable, BeasnInteface {

    @Inject
    private Uf uf;

    @Inject
    private UfService ufService;

    public UfBeans() {
    }

    @Override
    public void savar() {
        ufService.savar(uf);
        limpar();
    }

    @Override
    public void alterar() {
    }

    @Override
    public void excluir() {
    }

    @Override
    public void pesquisar() {
    }

    @Override
    public void limpar() {
        uf = new Uf();
    }

    //---------------------
    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

}
