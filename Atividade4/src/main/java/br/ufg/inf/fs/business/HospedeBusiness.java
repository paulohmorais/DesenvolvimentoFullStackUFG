package br.ufg.inf.fs.business;

import br.ufg.inf.fs.entities.Hospede;
import br.ufg.inf.fs.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedeBusiness {
    @Autowired
    private HospedeRepository hospedeRepository;

    public List<Hospede> findAll(){ return hospedeRepository.findAll();}

    public Hospede findById(Integer id){
        return hospedeRepository.findById(id).get();
    }

    public Hospede insert(Hospede hospede){ return hospedeRepository.save(hospede);}

    public Hospede update(Hospede hospede){ return hospedeRepository.save(hospede);}

    public void delete(Integer id){hospedeRepository.deleteById(id);}
}
