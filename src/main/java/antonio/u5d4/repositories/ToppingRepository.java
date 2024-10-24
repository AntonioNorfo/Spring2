package antonio.u5d4.repositories;

import antonio.u5d4.entities.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToppingRepository extends JpaRepository<Topping, Long> {

    List<Topping> findByNomeStartingWith(String prefix);

    @Query("SELECT t FROM Topping t WHERE t.prezzo < :prezzoMax")
    List<Topping> findToppingsWithPrezzoLessThan(double prezzoMax);
}
