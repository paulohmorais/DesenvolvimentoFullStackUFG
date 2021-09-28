package br.ufg.inf.fs.ctrl;

import br.ufg.inf.fs.business.HospedagemBusiness;
import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.exceptions.HospedagemException;

import java.util.ArrayList;
import java.util.List;

public class HospedagemCtrl {
    HospedagemBusiness business = new HospedagemBusiness();

    public List<Hospedagem> findAll(){
        List<Hospedagem> retorno = new ArrayList<>();

        try {
            retorno = business.findAll();
        } catch (HospedagemException e) {
            System.err.println(e.getMessage());
        }

        return retorno;
    }

    public Hospedagem findById(Integer id) {
        Hospedagem retorno = new Hospedagem();

        try {
            retorno = business.findById(id);
        } catch (HospedagemException e) {
            System.err.println(e.getMessage());
        }

        return retorno;
    }

    public Hospedagem insert(Hospedagem hospedagem) {
        try {
            hospedagem = business.insert(hospedagem);
        } catch (HospedagemException e) {
            System.err.println(e.getMessage());
        }
        return hospedagem;
    }

    public Hospedagem update(Hospedagem hospedagem) {
        try {
            hospedagem = business.update(hospedagem);
        } catch (HospedagemException e) {
            System.err.println(e.getMessage());
        }
        return hospedagem;
    }

    public void delete(Integer id) {
        try {
            business.delete(id);
        } catch (HospedagemException e) {
            System.err.println(e.getMessage());
        }
    }
}
