package Payment;

import Sheets.CheckSheet;
import Sheets.PaymentSheet;

import java.util.ArrayList;

/**
 * Created by alunoic on 24/08/18.
 */
public class Payment {
        private String paymentAgenda;

    public Payment(String paymentAgenda) {
        this.paymentAgenda = paymentAgenda;
    }

    public String getPaymentAgenda() {
        return paymentAgenda;
    }
}
