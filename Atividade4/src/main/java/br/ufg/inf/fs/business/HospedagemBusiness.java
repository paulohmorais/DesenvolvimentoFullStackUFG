package br.ufg.inf.fs.business;

import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.repositories.HospedagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedagemBusiness {
    @Autowired
    private HospedagemRepository hospedagemRepository;

    public List<Hospedagem> findAll(){ return hospedagemRepository.findAll();}

    public Hospedagem findById(Integer id){
        return hospedagemRepository.findById(id).get();
    }

    public Hospedagem insert(Hospedagem hospedagem){ return hospedagemRepository.save(hospedagem);}

    public Hospedagem update(Hospedagem hospedagem){ return hospedagemRepository.save(hospedagem);}

    public void delete(Integer id){hospedagemRepository.deleteById(id);}
}
