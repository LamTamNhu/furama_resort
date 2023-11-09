package repository.impl;

import model.Booking;
import model.Contract;
import repository.IBookingRepository;
import utils.BookingComparator;
import utils.file_io.CsvFileReader;
import utils.file_io.CsvFileWriter;

import java.time.LocalDate;
import java.util.*;

public class BookingRepository implements IBookingRepository {
    private static final BookingComparator bookingComparator = new BookingComparator();
    private static final Set<Booking> bookings = new TreeSet<>(bookingComparator);
    private static final Queue<Booking> bookingsForContract = new ArrayDeque<>();
    private static final List<Contract> contracts = new ArrayList<>();
    private final String BOOKING_PATH = "src/data/booking.csv";
    private final String CONTRACT_PATH = "src/data/contract.csv";
    private final String SEPARATOR = ",";

    private void updateFromFile(String PATH) {
        List<String> listToRead = CsvFileReader.readObjectFromFile(PATH);
        String bookingId;
        LocalDate startDate;
        LocalDate endDate;
        String serviceId;
        String customerId;
        String contractId;
        Double deposit;
        Double total;

        String[] parsedLine;
        if (listToRead == null) {
            System.out.println("Reading from empty file!");
            return;
        }
        if (PATH.contains("booking")) {
            bookings.clear();
            for (String line : listToRead) {
                parsedLine = line.split(SEPARATOR);
                bookingId = parsedLine[0];
                startDate = LocalDate.parse(parsedLine[1]);
                endDate = LocalDate.parse(parsedLine[2]);
                customerId = parsedLine[3];
                serviceId = parsedLine[4];
                bookings.add(new Booking(bookingId, startDate, endDate, customerId, serviceId));
            }
        } else if (PATH.contains("contract")) {
            contracts.clear();
            for (String line : listToRead) {
                parsedLine = line.split(SEPARATOR);
                contractId = parsedLine[0];
                bookingId = parsedLine[1];
                deposit = Double.valueOf(parsedLine[2]);
                total = Double.valueOf(parsedLine[3]);
                contracts.add(new Contract(contractId, bookingId, deposit, total));
            }
        }
    }

    public void writeToFile(String PATH) {
        List<String> listToWrite = new ArrayList<>();
        StringBuilder line;
        if (PATH.contains("booking")) {
            for (Booking e : bookings) {
                line = new StringBuilder(e.getBookingId()).append(SEPARATOR).append(e.getStartDate()).append(SEPARATOR).
                        append(e.getEndDate()).append(SEPARATOR).append(e.getCustomerId()).append(SEPARATOR).append(e.getServiceId());
                listToWrite.add(String.valueOf(line));
            }
        } else if (PATH.contains("contract")) {
            for (Contract e : contracts) {
                line = new StringBuilder(e.getContractId()).append(SEPARATOR).append(e.getBookingId()).append(SEPARATOR).
                        append(e.getDeposit()).append(SEPARATOR).append(e.getTotal());
                listToWrite.add(String.valueOf(line));
            }
        }
        CsvFileWriter.writeObjectToFile(listToWrite, PATH);
    }

    @Override
    public Object getAll() {
        updateFromFile(BOOKING_PATH);
        return bookings;
    }

    @Override
    public Object findById(String id) {
        return null;
    }

    @Override
    public Object findByName(String name) {
        return null;
    }

    @Override
    public boolean addEntry(Object entry) {
        Booking newEntryToAdd = (Booking) entry;
        updateFromFile(BOOKING_PATH);
        newEntryToAdd.setBookingId(generateNewId(newEntryToAdd));
        if (bookings.add(newEntryToAdd)) {
            writeToFile();
            return true;
        }
        return false;
    }

    private String generateNewId(Object entry) {
        int temp;
        String idNum;
        StringBuilder newIdBuilder;
        String newId;
        boolean isExist;
        do {
            newIdBuilder = new StringBuilder();
            isExist = false;
            temp = (int) (Math.random() * 9999);
            idNum = String.valueOf(temp);
            if (entry instanceof Booking) {
                newIdBuilder.append("BK-");
            } else if (entry instanceof Contract) {
                newIdBuilder.append("CT-");
            }
            int numLength = idNum.length();
            for (int i = numLength; i < 4; i++) {
                newIdBuilder.append("0");
            }
            newIdBuilder.append(idNum);
            newId = String.valueOf(newIdBuilder);
            if (entry instanceof Booking) {
                for (Booking e : bookings) {
                    if (newId.equals(e.getBookingId())) {
                        isExist = true;
                        break;
                    }
                }
            } else if (entry instanceof Contract) {
                for (Contract e : contracts) {
                    if (newId.equals(e.getContractId())) {
                        isExist = true;
                        break;
                    }
                }
            }
        } while (isExist);
        return newId;
    }

    @Override
    public boolean removeByID(String id) {
        return false;
    }

    @Override
    public void editEntry(String id, Object entry) {
    }

    @Override
    public void writeToFile() {

    }

    @Override
    public boolean addContract(Contract contract) {
        updateFromFile(CONTRACT_PATH);
        contract.setContractId(generateNewId(contract));
        contracts.add(contract);
        writeToFile(CONTRACT_PATH);
        return true;
    }

    @Override
    public Queue<Booking> getBookingListForContract() {
        updateFromFile(BOOKING_PATH);
        updateBookingContract();
        return bookingsForContract;
    }

    @Override
    public List<Contract> getAllContract() {
        updateFromFile(CONTRACT_PATH);
        return contracts;
    }

    private void updateBookingContract() {
        bookingsForContract.clear();
        for (Booking e : bookings) {
            if (e.getServiceId().contains("VL") || e.getServiceId().contains("HO")) {
                bookingsForContract.add(e);
            }
        }
    }
}
