package cap_software.hrms.entities.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Currencies")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "CurrencyName",length = 10,nullable = false,unique = true)
    private String currencyName;

    @Column(name = "CurrencyDeatil",length = 100)
    private String currencyDeatil;
}
