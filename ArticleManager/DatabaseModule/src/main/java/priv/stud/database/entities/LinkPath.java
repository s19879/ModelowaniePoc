package priv.stud.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "LINK_PATH")
public class LinkPath {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String xmlPath;
    private String domain;

    @ManyToOne
    private Site site;

    @OneToMany(mappedBy = "linkPath")
    private Set<ContentPath> contentPaths;
}
