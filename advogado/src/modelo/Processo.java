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

    @Column(name = "idComarca")
    private Long idComarca;

    @Column(name = "idVara")
    private Long idVara;

    @Column(name = "idTipoDaAcao")
    private Long idTipoDaAcao;

    @Column(name = "idFase")
    private Long idFase;

    @Column(name = "idCliente")
    private Long idCliente;

    @Column(name = "status")
    private String status;

    @Column(name = "posicao")
    private String posicao;

    @Column(name = "parteOposta")
    private String parteOposta;

    @Column(name = "advogadoOposto")
    private String advogadoOposto;

    @Column(name = "idJuiz")
    private Long idJuiz;

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

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

    public Long getIdFase() {
        return idFase;
    }

    public void setIdFase(Long fase) {
        this.idFase = fase;
    }

    public Double getHonorarios() {
        return honorarios;
    }

    public void setHonorarios(Double honorarios) {
        this.honorarios = honorarios;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdComarca() {
        return idComarca;
    }

    public void setIdComarca(Long idComarca) {
        this.idComarca = idComarca;
    }

    public Long getIdJuiz() {
        return idJuiz;
    }

    public void setIdJuiz(Long idJuiz) {
        this.idJuiz = idJuiz;
    }

    public Long getIdVara() {
        return idVara;
    }

    public void setIdVara(Long idVara) {
        this.idVara = idVara;
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

    public Long getIdTipoDaAcao() {
        return idTipoDaAcao;
    }

    public void setIdTipoDaAcao(Long idTipoDaAcao) {
        this.idTipoDaAcao = idTipoDaAcao;
    }

    public Double getValorDaCausa() {
        return valorDaCausa;
    }

    public void setValorDaCausa(Double valorDaCausa) {
        this.valorDaCausa = valorDaCausa;
    }

}
