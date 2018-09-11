package donation.solutions.hamza.com.donation.model;

public class NotificationResponce {

    private String id;

    private String text;

    private String creationDate;

    private int v;

    public NotificationResponce(String id, String text, String creationDate, int v) {
        this.id = id;
        this.text = text;
        this.creationDate = creationDate;
        this.v = v;
    }

    public NotificationResponce(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public int getV() {
        return v;
    }

    @Override
    public String toString() {
        return "NotificationResponce{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", v=" + v +
                '}';
    }
}
