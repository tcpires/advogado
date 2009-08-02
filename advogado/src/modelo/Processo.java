/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author andrehadm
 */
@Entity
@Table(name="Processo")
public class Processo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id = null;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "comarca")
    private Comarca comarca;

    @Column(name = "vara")
    private Vara vara;

    @Column(name = "tipoDaAcao")
    private String tipoDaAcao;

    @Column(name = "fase")
    private String fase;

    @Column(name = "cliente")
    private Cliente cliente;

    @Column(name = "status")
    private String status;

    @Column(name = "posicao")
    private String posicao;

    @Column(name = "parteOposta")
    private String parteOposta;

    @Column(name = "advogadoOposto")
    private String advogadoOposto;

    @Column(name = "juiz")
    private Juiz juiz;

    @Column(name = "valorDaCausa")
    private Double valorDaCausa;

    @Column(name = "honorarios")
    private Double honorarios;
    //private Audiencia audiencias;

    @Column(name = "observacoes")
    private String observacoes;
    //private Processo apenso1;
    //private Processo apenso2;
    //private Processo apenso3;
    //private Andamento andamentos;

    @Column(name = "estrategia")
    private String estrategia;

    public Processo() {
        //Construtor default
    }

    public String getAdvogadoOposto() {
        return advogadoOposto;
    }

    public void setAdvogadoOposto(String advogadoOposto) {
        this.advogadoOposto = advogadoOposto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Comarca getComarca() {
        return comarca;
    }

    public void setComarca(Comarca comarca) {
        this.comarca = comarca;
    }

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public Double getHonorarios() {
        return honorarios;
    }

    public void setHonorarios(Double honorarios) {
        this.honorarios = honorarios;
    }

    public Juiz getJuiz() {
        return juiz;
    }

    public void setJuiz(Juiz juiz) {
        this.juiz = juiz;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getParteOposta() {
        return parteOposta;
    }

    public void setParteOposta(String parteOposta) {
        this.parteOposta = parteOposta;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipoDaAcao() {
        return tipoDaAcao;
    }

    public void setTipoDaAcao(String tipoDaAcao) {
        this.tipoDaAcao = tipoDaAcao;
    }

    public Double getValorDaCausa() {
        return valorDaCausa;
    }

    public void setValorDaCausa(Double valorDaCausa) {
        this.valorDaCausa = valorDaCausa;
    }

    public Vara getVara() {
        return vara;
    }

    public void setVara(Vara vara) {
        this.vara = vara;
    }

}
