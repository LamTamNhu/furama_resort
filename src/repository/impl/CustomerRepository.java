package repository.impl;

import model.human.Customer;
import repository.ICustomerRepository;
import utils.file_io.CsvFileReader;
import utils.file_io.CsvFileWriter;

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
        updateFromFile();
        for (Customer e : customers) {
            if (id.equals(e.getCustomerId())) {
                return e;
            }
        }
        return null;
    }

    @Override
    public Object findByName(String name) {
        updateFromFile();
        List<Customer> result = new ArrayList<>();
        name = name.toUpperCase();
        String nameInList;
        for (Customer e : customers) {
            nameInList = e.getName().toUpperCase();
            if (nameInList.contains(name)) {
                result.add(e);
            }
        }
        return result;
    }

    @Override
    public void addEntry(Object entry) {
        updateFromFile();
        customers.add((Customer) entry);
        writeToFile();
    }

    @Override
    public void removeByID(String id) {
        updateFromFile();
        int length = customers.size();
        for (int i = 0; i < length; i++) {
            if (id.equals(customers.get(i).getCustomerId())) {
                customers.remove(i);
                break;
            }
        }
        writeToFile();
    }

    @Override
    public void editEntry(String id, Object entry) {
        updateFromFile();
        int length = customers.size();
        for (int i = 0; i < length; i++) {
            if (id.equals(customers.get(i).getCustomerId())) {
                customers.set(i, (Customer) entry);
            }
        }
        writeToFile();
    }
}

