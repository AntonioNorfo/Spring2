package antonio.u5d4.repositories;

import antonio.u5d4.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {


    List<Drink> findByPrezzoLessThan(double prezzoMassimo);

    @Query("SELECT d FROM Drink d WHERE d.calorie > :calorieMinime")
    List<Drink> findDrinksWithCalorieGreaterThan(double calorieMinime);
}
