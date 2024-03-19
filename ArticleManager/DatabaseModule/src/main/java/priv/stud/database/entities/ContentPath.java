package priv.stud.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;


import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "CONTENT_PATH")
public class ContentPath {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Type(type = "priv.stud.database.entities.ContentType")
    private ContentType type;
    private String xmlPath;

    @ManyToOne
    private LinkPath linkPath;
}
