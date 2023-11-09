package repository;

import model.Booking;
import model.Contract;

import java.util.List;
import java.util.Queue;

public interface IBookingRepository extends Repository{
    boolean addContract(Contract contract);

    Queue<Booking> getBookingListForContract();

    List<Contract> getAllContract();
}
