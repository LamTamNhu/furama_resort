package model;

public class Contract {
    private String contractId;
    private String bookingId;
    private Double deposit;
    private Double total;

    public Contract() {
    }

    public Contract(String contractId, String bookingId, Double deposit, Double total) {
        this.contractId = contractId;
        this.bookingId = bookingId;
        this.deposit = deposit;
        this.total = total;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
