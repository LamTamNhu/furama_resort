package repository.impl;

import model.Customer;
import repository.ICustomerRepository;
import utils.CsvFileReader;
import utils.CsvFileWriter;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final List<Customer> customers = new ArrayList<>();
    private final String PATH = "src/data/customer.csv";

    private void updateFromFile() {
        List<String> rawCsvList = CsvFileReader.readObjectFromFile(PATH);
        if (rawCsvList == null) {
            System.out.println("List is empty!");
            return;
        }
        customers.clear();
        for (String line : rawCsvList) {
            Customer customerToAdd = new Customer();
            customerToAdd.setAttributesFromCsvFormat(line);
            customers.add(customerToAdd);
        }
    }

    private void writeToFile() {
        List<String> listToWrite = new ArrayList<>();
        for (Customer e : customers) {
            listToWrite.add(e.convertAttributesToCsvFormat());
        }
        CsvFileWriter.writeObjectToFile(listToWrite, PATH);
    }

    @Override
    public Object getAll() {
        updateFromFile();
        return customers;
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
    public void addEntry(Object entry) {
        updateFromFile();
        customers.add((Customer) entry);
        writeToFile();
    }

    @Override
    public void removeByID(String id) {

    }

    @Override
    public void editEntry(String id, Object entry) {

    }
}
