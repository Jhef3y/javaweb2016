/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetoMave.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jhef3y
 */
@Entity
@Table(name = "receita")
public class Receita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank
    @Column(name = "nome_Receita")
    private String nmReceita;
   
    @Column(name = "descricao_Receita")
    private String dsReceita;
    
    private boolean habilitado;
    
    @Column(name = "data_Operacao")
    private Date dtOperacao;
    
    @Column(name = "valor_Receita")
    private int vlReceita;

    public Receita() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNmReceita() {
        return nmReceita;
    }

    public void setNmReceita(String nmReceita) {
        this.nmReceita = nmReceita;
    }

    public String getDsReceita() {
        return dsReceita;
    }

    public void setDsReceita(String dsReceita) {
        this.dsReceita = dsReceita;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Date getDtOperacao() {
        return dtOperacao;
    }

    public void setDtOperacao(Date dtOperacao) {
        this.dtOperacao = dtOperacao;
    }

    public int getVlReceita() {
        return vlReceita;
    }

    public void setVlReceita(int vlReceita) {
        this.vlReceita = vlReceita;
    }
    
    
}
