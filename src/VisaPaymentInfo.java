import java.util.Calendar;

public class VisaPaymentInfo {
    private String cardNumber;
    private short cvv;
    private Calendar expiryDate; 

    public VisaPaymentInfo() {
    }

    public VisaPaymentInfo(String cardNumber, short cvv, Calendar expiryDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public short getCvv() {
        return cvv;
    }

    public void setCvv(short cvv) {
        this.cvv = cvv;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }
}
