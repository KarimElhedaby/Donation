package donation.solutions.hamza.com.donation.model;

public class DonateResponse {
    private final String status;

    private final String creationDate;

    private final String id;

    private final String price;

    private final String desc;

    private final String request;

    private final String user;

    private final int v;

    public DonateResponse(String status, String creationDate, String id, String price, String desc,
                          String request, String user, int v) {
        this.status = status;
        this.creationDate = creationDate;
        this.id = id;
        this.price = price;
        this.desc = desc;
        this.request = request;
        this.user = user;
        this.v = v;
    }

    public String getStatus() {
        return status;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public String getRequest() {
        return request;
    }

    public String getUser() {
        return user;
    }

    public int getV() {
        return v;
    }
}
