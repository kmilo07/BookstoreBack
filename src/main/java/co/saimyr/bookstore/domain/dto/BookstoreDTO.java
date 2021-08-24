package co.saimyr.bookstore.domain.dto;

public class BookstoreDTO {
    private int isbnId;
    private String noun;
    private String writer;
    private String publisher;
    private String gender;

    public int getIsbnId() {
        return isbnId;
    }

    public void setIsbnId(int isbnId) {
        this.isbnId = isbnId;
    }

    public String getNoun() {
        return noun;
    }

    public void setNoun(String noun) {
        this.noun = noun;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
