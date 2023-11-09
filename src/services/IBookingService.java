package services;

import model.Booking;
import model.Contract;

import java.util.List;
import java.util.Queue;

public interface IBookingService extends Service {
    boolean addContract(Contract contract);

    Queue<Booking> getBookingListForContract();

    List<Contract> getAllContract();
}
