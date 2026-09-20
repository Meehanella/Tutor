import java.time.LocalDate;

public class SessionManager {
    public void requestSession(String learnerId, int tutorId, String subject, LocalDate date) {
        // Logic to insert a pending session request into Supabase PostgreSQL via REST API
        System.out.println("Session requested for " + subject + " on " + date);
    }
}
