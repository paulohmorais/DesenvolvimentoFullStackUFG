package br.ufg.inf.fs20211.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_hospedagem")
public class Hospedagem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_hospedagem")
    private Integer idHospedagem;

    @OneToOne
    @JoinColumn(name="id_quarto")
    private Quarto quarto;

    @OneToOne
    @JoinColumn(name="id_hospede")
    private Hospede hospede;

    @Column(name="dt_checkin")
    private LocalDate dtCheckin;

    @Column(name="dt_checkout")
    private LocalDate dtCheckout;

    public Hospedagem() {
        super();
    }

    public Hospedagem(Integer idHospedagem, Quarto quarto, Hospede hospede, LocalDate dtCheckin, LocalDate dtCheckout) {
        this.idHospedagem = idHospedagem;
        this.quarto = quarto;
        this.hospede = hospede;
        this.dtCheckin = dtCheckin;
        this.dtCheckout = dtCheckout;
    }

    public Integer getIdHospedagem() {
        return idHospedagem;
    }

    public void setIdHospedagem(Integer idHospedagem) {
        this.idHospedagem = idHospedagem;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public LocalDate getDtCheckin() {
        return dtCheckin;
    }

    public void setDtCheckin(LocalDate dtCheckin) {
        this.dtCheckin = dtCheckin;
    }

    public LocalDate getDtCheckout() {
        return dtCheckout;
    }

    public void setDtCheckout(LocalDate dtCheckout) {
        this.dtCheckout = dtCheckout;
    }

    @Override
    public String toString() {
        return "Hospedagem [idHospedagem=" + idHospedagem + ", quarto=" + quarto + ", hospede=" + hospede
                + ", dtCheckin=" + dtCheckin + ", dtCheckout=" + dtCheckout + "]";
    }
}
