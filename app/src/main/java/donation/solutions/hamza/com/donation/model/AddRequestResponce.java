package donation.solutions.hamza.com.donation.model;

import java.util.List;


public class AddRequestResponce {

    private final List<Object> doner;
    private final String status;
    private final List<String> img;
    private final String creationDate;
    private final String id;
    private final String title;
    private final String desc;
    private final String user;

    private final int v;

    public AddRequestResponce(List<Object> doner, String status, List<String> img,
                              String creationDate, String id, String title, String desc, String user, int v) {
        this.doner = doner;
        this.status = status;
        this.img = img;
        this.creationDate = creationDate;
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.user = user;
        this.v = v;
    }

    public List<Object> getDoner() {
        return doner;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getImg() {
        return img;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getUser() {
        return user;
    }

    public int getV() {
        return v;
    }

    @Override
    public String toString() {
        return "AddRequestResponce{" +
                "doner=" + doner +
                ", status='" + status + '\'' +
                ", img=" + img +
                ", creationDate='" + creationDate + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", user='" + user + '\'' +
                ", v=" + v +
                '}';
    }
}
