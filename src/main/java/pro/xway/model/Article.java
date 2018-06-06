package pro.xway.model;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "timestamp")
    private Long date;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "body")
    private String body;

    public long getId() {
        return id;
    }

    public Article setId(long id) {
        this.id = id;
        return this;
    }

    public Long getDate() {
        return date;
    }

    public Article setDate(Long date) {
        this.date = date;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Article setBody(String body) {
        this.body = body;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Article setCategory(Category category) {
        this.category = category;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Article setAuthor(User author) {
        this.author = author;
        return this;
    }
}
