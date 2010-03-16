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
@Table(name = "Audiencia")
public class Audiencia implements Serializable {

    public Audiencia() {
        //Construtor default
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id = null;

    @Column(name = "idProcesso")
    private Long idProcesso;

    @Column(name = "dataAudiencia")
    private String dataAudiencia;

    @Column(name = "horaAudiencia")
    private String horaAudiencia;

    @Column(name = "historico")
    private String historico;

    public String getDataAudiencia() {
        return dataAudiencia;
    }

    public void setDataAudiencia(String dataAudiencia) {
        this.dataAudiencia = dataAudiencia;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getHoraAudiencia() {
        return horaAudiencia;
    }

    public void setHoraAudiencia(String horaAudiencia) {
        this.horaAudiencia = horaAudiencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Long idProcesso) {
        this.idProcesso = idProcesso;
    }
}
