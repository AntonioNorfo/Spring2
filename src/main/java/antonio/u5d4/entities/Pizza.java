package antonio.u5d4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@ToString(exclude = "toppings")
public class Pizza extends Prodotto {

    @ManyToMany
    private List<Topping> toppings;

    public Pizza(String nome, double prezzoBase, double calorie, List<Topping> toppings) {
        super(nome, prezzoBase, calorie);
        this.toppings = toppings;
    }

    public double getPrezzoTotale() {
        return getPrezzo() + toppings.stream().mapToDouble(Topping::getPrezzo).sum();
    }

    public String getDescrizione() {
        StringBuilder descrizione = new StringBuilder(getNome() + " con: pomodoro, mozzarella");
        toppings.forEach(topping -> descrizione.append(", ").append(topping.getNome()));
        return descrizione.toString();
    }
}
