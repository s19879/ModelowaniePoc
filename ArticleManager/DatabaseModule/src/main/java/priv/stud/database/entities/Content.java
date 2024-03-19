package priv.stud.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "CONTENT")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date addDate;
    private String url;
    private String title;
    private String content;

    @ManyToOne
    private Site site;
}
