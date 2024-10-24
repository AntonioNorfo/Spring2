package antonio.u5d4.runners;

import antonio.u5d4.entities.Drink;
import antonio.u5d4.entities.Pizza;
import antonio.u5d4.entities.Topping;
import antonio.u5d4.repositories.DrinkRepository;
import antonio.u5d4.repositories.PizzaRepository;
import antonio.u5d4.repositories.ToppingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);
    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private DrinkRepository drinkRepository;
    @Autowired
    private ToppingRepository toppingRepository;

    @Override
    public void run(String... args) throws Exception {

        Topping mozzarella = new Topping("Mozzarella", 0.50, 100);
        Topping pepperoni = new Topping("Pepperoni", 1.50, 150);
        toppingRepository.saveAll(Arrays.asList(mozzarella, pepperoni));

        Pizza pizza = new Pizza("Margherita", 5.00, 600, Arrays.asList(mozzarella));
        pizzaRepository.save(pizza);

        Drink drink = new Drink("Coca Cola", 2.50, 150, "Alta in zuccheri");
        drinkRepository.save(drink);


        List<Pizza> pizzeMargherita = pizzaRepository.findByNomeContaining("Margherita");
        logger.info("Pizze trovate contenenti 'Margherita': {}", pizzeMargherita);

        List<Pizza> pizzeCostose = pizzaRepository.findPizzeWithPrezzoGreaterThan(4.00);
        logger.info("Pizze con prezzo maggiore di 4.00: {}", pizzeCostose);

        List<Drink> drinksEconomici = drinkRepository.findByPrezzoLessThan(3.00);
        logger.info("Drinks con prezzo inferiore a 3.00: {}", drinksEconomici);

        List<Drink> drinksCalorici = drinkRepository.findDrinksWithCalorieGreaterThan(100);
        logger.info("Drinks con calorie maggiori di 100: {}", drinksCalorici);

        List<Topping> toppingsM = toppingRepository.findByNomeStartingWith("M");
        logger.info("Toppings che iniziano con 'M': {}", toppingsM);

        List<Topping> toppingsEconomici = toppingRepository.findToppingsWithPrezzoLessThan(1.00);
        logger.info("Toppings con prezzo inferiore a 1.00: {}", toppingsEconomici);
    }
}
