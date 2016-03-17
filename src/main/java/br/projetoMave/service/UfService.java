/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetoMave.service;

import br.projetoMave.dao.UfDao;
import br.projetoMave.model.Uf;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author tibe
 */
public class UfService implements Serializable{
    
    @Inject
    private UfDao ufDao;


    public void savar(Uf uf) {
        try {
            ufDao.save(uf);
        } catch (Exception e) {
        }
    }


    public void alterar() {
    }

    
    public void excluir() {
    }

    public void pesquisar() {
    }
    
    
    
    
}
