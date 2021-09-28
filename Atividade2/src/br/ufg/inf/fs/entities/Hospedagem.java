package br.ufg.inf.fs.entities;

import java.time.LocalDate;

public class Hospedagem {
    private Integer idHospedagem;
    private Quarto quarto;
    private Hospede hospede;
    private LocalDate dtCheckin;
    private LocalDate dtCheckout;

    public Hospedagem() {
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
