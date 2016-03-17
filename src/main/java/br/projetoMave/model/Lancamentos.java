/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetoMave.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jhef3y
 */
@Entity
@Table(name = "lancamentos")
public class Lancamentos{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank
    @Column(name = "data_Operacao")
    private Date dtOperacao;
    
    @NotBlank
    @Column(name = "avista")
    private boolean avista;
    
    @Column(name = "ds_Lancamentos")
    private String dsLancamentos;
    
    @ManyToOne
    @JoinColumn(name = "despesas_id")
    private Despesas despesas;
    
    public Lancamentos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDtOperacao() {
        return dtOperacao;
    }

    public void setDtOperacao(Date dtOperacao) {
        this.dtOperacao = dtOperacao;
    }

    public boolean isAvista() {
        return avista;
    }

    public void setAvista(boolean avista) {
        this.avista = avista;
    }

    public String getDsLancamentos() {
        return dsLancamentos;
    }

    public void setDsLancamentos(String dsLancamentos) {
        this.dsLancamentos = dsLancamentos;
    }
    
    
    
    
    
}
