package priv.stud.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "COOKIE")
public class Cookie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String value;

    private Date validDate;

    @ManyToOne
    @JoinColumn(name = "site_id", referencedColumnName = "id")
    private Site site;
}
