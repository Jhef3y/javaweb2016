package br.projetoMave.dao;


import br.projetoMave.model.Uf;
import java.io.Serializable;

public class UfDao extends GenericDao<Uf> implements Serializable {

    public UfDao() {
        setClazz(Uf.class);
    }

}
