package antonio.u5d4.entities;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString
public class Drink extends Prodotto {

    private String informazioniNutrizionali;

    public Drink(String nome, double prezzo, double calorie, String informazioniNutrizionali) {
        super(nome, prezzo, calorie);
        this.informazioniNutrizionali = informazioniNutrizionali;
    }
}
