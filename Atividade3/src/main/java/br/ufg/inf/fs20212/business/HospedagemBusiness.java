package br.ufg.inf.fs20211.business;

import br.ufg.inf.fs20211.config.DaoFactory;
import br.ufg.inf.fs20211.dao.HospedagemDao;
import br.ufg.inf.fs20211.entities.Hospedagem;
import br.ufg.inf.fs20211.exceptions.HospedagemException;

import java.util.List;

public class HospedagemBusiness {
    HospedagemDao dao = new HospedagemDao(DaoFactory.getEntityManager());

    public List<Hospedagem> findAll() throws HospedagemException {
        return dao.findAll();
    }

    public Hospedagem findById(Integer id) throws HospedagemException {
        return dao.findById(id);
    }

    public Hospedagem insert(Hospedagem hospedagem) throws HospedagemException {
        return dao.insert(hospedagem);
    }

    public Hospedagem update(Hospedagem hospedagem) throws HospedagemException {
        return dao.update(hospedagem);
    }

    public void delete(Integer id) throws HospedagemException {
        Hospedagem hospedagem = this.findById(id);
        dao.delete(hospedagem);
    }
}
