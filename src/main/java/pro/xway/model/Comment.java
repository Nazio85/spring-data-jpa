package pro.xway.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    @ManyToOne
    @JoinColumn(name = "article")
    private Article article;

    @Column(name = "timestamp")
    private Long timestamp;

    @Lob
    @Column(name = "body")
    private String body;

    public long getId() {
        return id;
    }

    public Comment setId(long id) {
        this.id = id;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Comment setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Article getArticle() {
        return article;
    }

    public Comment setArticle(Article article) {
        this.article = article;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Comment setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Comment setBody(String body) {
        this.body = body;
        return this;
    }
}
