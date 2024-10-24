package antonio.u5d4.repositories;

import antonio.u5d4.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    List<Pizza> findByNomeContaining(String nome);

    @Query("SELECT p FROM Pizza p WHERE p.prezzo > :prezzoMinimo")
    List<Pizza> findPizzeWithPrezzoGreaterThan(double prezzoMinimo);
}
