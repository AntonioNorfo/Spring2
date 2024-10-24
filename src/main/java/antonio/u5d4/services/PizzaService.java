package antonio.u5d4.services;

import antonio.u5d4.entities.Pizza;
import antonio.u5d4.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    public List<Pizza> findByNome(String nome) {
        return pizzaRepository.findByNomeContaining(nome);
    }

    public List<Pizza> findPizzeWithPrezzoGreaterThan(double prezzoMinimo) {
        return pizzaRepository.findPizzeWithPrezzoGreaterThan(prezzoMinimo);
    }
}
