package org.koreait;

public class Article {
    int id;
    String title;
    String body;
    Member author;
    String regDate;
    String updateDate;

    public Article(int id, String title, String body, Member author, String regDate, String updateDate) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
        this.regDate = regDate;
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author=" + author +
                ", regDate='" + regDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Member getAuthor() {
        return author;
    }

    public void setAuthor(Member author) {
        this.author = author;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}