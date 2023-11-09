package repository.impl;

import model.Booking;
import repository.IBookingRepository;
import utils.BookingComparator;
import utils.file_io.CsvFileReader;
import utils.file_io.CsvFileWriter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BookingRepository implements IBookingRepository {
    private static final BookingComparator bookingComparator = new BookingComparator();
    private static final Set<Booking> bookings = new TreeSet<>(bookingComparator);
    private final String PATH = "src/data/booking.csv";
    private final String SEPARATOR = ",";

    private void updateFromFile() {
        List<String> listToRead = CsvFileReader.readObjectFromFile(PATH);
        String bookingId;
        LocalDate startDate;
        LocalDate endDate;
        String serviceId;
        String customerId;

        String[] parsedLine;
        if (listToRead == null) {
            System.out.println("Reading from empty file!");
            return;
        }
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
    }

    public void writeToFile() {
        List<String> listToWrite = new ArrayList<>();
        StringBuilder line;
        for (Booking e : bookings) {
            line = new StringBuilder(e.getBookingId()).append(SEPARATOR).append(e.getStartDate()).append(SEPARATOR).
                    append(e.getEndDate()).append(SEPARATOR).append(e.getCustomerId()).append(SEPARATOR).append(e.getServiceId());
            listToWrite.add(String.valueOf(line));
        }
        CsvFileWriter.writeObjectToFile(listToWrite, PATH);
    }

    @Override
    public Object getAll() {
        updateFromFile();
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
        updateFromFile();
        generateNewBookingId(newEntryToAdd);
        if (bookings.add(newEntryToAdd)) {
            writeToFile();
            return true;
        }
        return false;
    }

    private void generateNewBookingId(Booking entry) {
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
            newIdBuilder.append("BK-");
            int numLength = idNum.length();
            for (int i = numLength; i < 4; i++) {
                newIdBuilder.append("0");
            }
            newIdBuilder.append(idNum);
            newId = String.valueOf(newIdBuilder);
            for (Booking e : bookings) {
                if (newId.equals(e.getBookingId())) {
                    isExist = true;
                    break;
                }
            }
        } while (isExist);
        entry.setBookingId(String.valueOf(newId));
    }

    @Override
    public boolean removeByID(String id) {
        return false;
    }

    @Override
    public void editEntry(String id, Object entry) {

    }
}
