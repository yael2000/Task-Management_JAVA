package classes;

public class Implement extends TeamMember {
    public int rating;

    public Implement() {
    }

    public Implement(int id, String name, String email, int rating) {
        super(id, name, email);
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
