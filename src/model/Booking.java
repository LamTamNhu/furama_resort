package model;

import java.time.LocalDate;

public class Booking {
    private String bookingId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String customerId;
    private String serviceId;

    public Booking() {
    }

    public Booking(String bookingId, LocalDate startDate, LocalDate endDate, String customerId, String serviceId) {
        this.bookingId = bookingId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public Booking(LocalDate startDate, LocalDate endDate, String customerId, String serviceId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "bookingId='" + bookingId + '\'' +
               ", startDate=" + startDate.getDayOfMonth() + "-" + startDate.getMonth() + "-" + startDate.getYear() +
               ", endDate=" + endDate.getDayOfMonth() + "-" + endDate.getMonth() + "-" + endDate.getYear() +
               ", customerId='" + customerId + '\'' +
               ", serviceId='" + serviceId + '\'';
    }
}
