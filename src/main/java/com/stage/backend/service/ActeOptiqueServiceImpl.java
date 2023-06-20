package com.stage.backend.service;

import com.stage.backend.entity.ActeOptique;
import com.stage.backend.repository.ActeOptiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActeOptiqueServiceImpl implements  ActeOptiqueService {
    @Autowired
    private final ActeOptiqueRepository acteOptiqueRepository;
    @Autowired
    public ActeOptiqueServiceImpl(ActeOptiqueRepository acteOptiqueRepository){
        this.acteOptiqueRepository = acteOptiqueRepository;
    }
    @Override
    public ActeOptique addActe(ActeOptique acteOptique) {
          return  acteOptiqueRepository.save(acteOptique);
    }

    @Override
    public ActeOptique updateActe(Long id, ActeOptique acteOptique) {
        Optional<ActeOptique> exsisting= acteOptiqueRepository.findById(id);

        if( exsisting.isPresent()){
            ActeOptique acteOptique1 = exsisting.get();
           // acteOptique1.setMntDepense(acteOptique.getMntDepense());
           // acteOptique1.setDate(acteOptique.getDate());
            if (acteOptique.getMntDepense() == 0) {
                acteOptique1.setMntDepense(acteOptique1.getMntDepense());
            } else {
                acteOptique1.setMntDepense(acteOptique.getMntDepense());
            }
            acteOptique1.setMatriculeAdherent(acteOptique.getMatriculeAdherent());
            // to continue
            return acteOptiqueRepository.save(acteOptique1);
        }else {
            throw new RuntimeException("Acte non found with id ="+id);
        }

    }


    @Override
    public void deleteActe(Long id) {
            acteOptiqueRepository.deleteById(id);
    }

    @Override
    public List<ActeOptique> getAllActes() {
        return (List<ActeOptique>) acteOptiqueRepository.findAll();
    }

    @Override
    public Optional<ActeOptique> getActe(Long id) {
        return acteOptiqueRepository.findById(id);
    }

   @Override
    public List<ActeOptique> getListActeByMatricule( String matriculeAdherent) {
        List<ActeOptique> filteredActes = new ArrayList<>();
        List<ActeOptique> actes = (List<ActeOptique>) acteOptiqueRepository.findAll();
        for (ActeOptique acte : actes) {
            if (acte.getMatriculeAdherent().equals(matriculeAdherent)) {
                filteredActes.add(acte);
            }
        }

        return filteredActes;
    }

}
