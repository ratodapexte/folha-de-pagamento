package sales;

/**
 * Created by alunoic on 24/08/18.
 */
public class Sales {
    private double price;
    private String date;

    public Sales(double price, String date) {
        this.price = price;
        this.date = date;
    }

    public double getPrice() {
        return price;
    }
}
