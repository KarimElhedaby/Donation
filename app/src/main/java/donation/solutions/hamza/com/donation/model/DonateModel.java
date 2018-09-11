package donation.solutions.hamza.com.donation.model;

public class DonateModel {

    private final int price;

    private final String desc;


    public DonateModel(int price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }
}
