package pl.coderslab.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Range;
import pl.coderslab.app.validation.BookValidation;
import pl.coderslab.app.validation.PropositionsGroup;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5,groups = {BookValidation.class,PropositionsGroup.class})
    private String title;

    @Range(min = 0, max = 10,groups = {BookValidation.class})
    private Integer rating;

    @Size(max = 600,groups = {BookValidation.class, PropositionsGroup.class})
    private String description;

    @Min(value=1,groups = {BookValidation.class})
    private Integer pages;

    @NotNull(groups={PropositionsGroup.class})
    private boolean proposition;

    @NotNull(groups = {BookValidation.class})
    @JsonIgnore
    @ManyToMany
            (fetch = FetchType.EAGER)
    private List<Author> authors = new ArrayList<>();

    @NotNull(groups = {BookValidation.class})
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Integer getPages() {
        return pages;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}