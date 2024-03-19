package priv.stud.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "SITE")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String url;

    private boolean cookiesAccepted;

    @OneToMany(mappedBy = "site")
    private Set<Cookie> cookies;

    @OneToMany(mappedBy = "site")
    private Set<LinkPath> paths;

    @OneToMany(mappedBy = "site")
    private Set<Content> contents;

    public Site(@NotNull String name, @NotNull String url, boolean cookiesAccepted){
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.url = Objects.requireNonNull(url, "Url cannot be null");
        this.cookiesAccepted = cookiesAccepted;
    }
}


