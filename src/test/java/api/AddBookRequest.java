package api;

import java.util.Collections;
import java.util.List;

public class AddBookRequest {
    private String userId;
    private List<Isbn> collectionOfIsbns;

    public AddBookRequest(String userId, String isbn) {
        this.userId = userId;
        this.collectionOfIsbns = Collections.singletonList(new Isbn(isbn));
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Isbn> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setCollectionOfIsbns(List<Isbn> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }

    public static class Isbn {
        private String isbn;

        public Isbn(String isbn) {
            this.isbn = isbn;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }
    }
}
