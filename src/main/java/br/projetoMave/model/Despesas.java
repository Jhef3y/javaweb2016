/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetoMave.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jhef3y
 */
@Entity
@Table(name = "despesas")
public class Despesas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank
    @Column(name = "nome_Despesa")
    private String nmDespesa;
    
    @Column(name = "descricao_Despesa")
    private String dsDespesa;
    
    @NotBlank
    private boolean habilitado;

    @OneToMany(mappedBy = "despesas", cascade = CascadeType.ALL)
    private List<Lancamentos> lancamentos = new ArrayList<>();
    
    public Despesas() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNmDespesa() {
        return nmDespesa;
    }

    public void setNmDespesa(String nmDespesa) {
        this.nmDespesa = nmDespesa;
    }

    public String getDsDespesa() {
        return dsDespesa;
    }

    public void setDsDespesa(String dsDespesa) {
        this.dsDespesa = dsDespesa;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    
    
}
