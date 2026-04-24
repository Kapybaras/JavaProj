package uk.ac.bangor.cs.a3.academigymraeg.services;

import uk.ac.bangor.cs.a3.academigymraeg.models.Noun;
import uk.ac.bangor.cs.a3.academigymraeg.repositories.NounRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NounService {

    @Autowired
    private NounRepository nounRepository;

    public List<Noun> getAllNouns() {
        return nounRepository.findAll();
    }

    public void saveNoun(Noun noun) {
        nounRepository.save(noun);
    }

    public Noun getNounById(Long id) {
        return nounRepository.findById(id).orElse(null);
    }

    public void deleteNoun(Long id) {
        nounRepository.deleteById(id);
    }
}