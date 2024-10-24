package antonio.u5d4.entities;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString
public class Topping extends Prodotto {

    public Topping(String nome, double prezzo, double calorie) {
        super(nome, prezzo, calorie);
    }

}
