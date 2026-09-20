import java.util.List;

public class Tutor extends User {
    private int tutorId;
    private List<String> subjects;
    private double rating;
    private boolean isVerified;

    public Tutor(String userId, String name, String email, int tutorId, List<String> subjects, double rating) {
        super(userId, name, email, "tutor");
        this.tutorId = tutorId;
        this.subjects = subjects;
        this.rating = rating;
        this.isVerified = false;
    }

    public void acceptSession(int sessionId) {
        System.out.println("Tutor " + getName() + " accepted session ID: " + sessionId);
    }

    @Override
    public void login() {
        System.out.println("Tutor dashboard loaded for: " + getName());
    }
}
