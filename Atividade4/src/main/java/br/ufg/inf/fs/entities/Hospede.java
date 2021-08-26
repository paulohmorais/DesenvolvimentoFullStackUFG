package br.ufg.inf.fs.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_hospede")
public class Hospede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hospede")
    private Integer idHospede;

    @Column(name = "nm_hospede")
    private String nmHospede;

    @Column(name = "dt_nascimento")
    private LocalDate dtNascimento;

    @Column(name = "cpf")
    private Integer cpf;

    public Hospede() {
        super();
    }

    public Hospede(Integer idHospede, String nmHospede, LocalDate dtNascimento, Integer cpf) {
        this.idHospede = idHospede;
        this.nmHospede = nmHospede;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
    }

    public Integer getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(Integer idHospede) {
        this.idHospede = idHospede;
    }

    public String getNmHospede() {
        return nmHospede;
    }

    public void setNmHospede(String nmHospede) {
        this.nmHospede = nmHospede;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Hospede [idHospede=" + idHospede + ", nmHospede=" + nmHospede + ", dtNascimento=" + dtNascimento + ", cpf="
                + cpf + "]";
    }
}
