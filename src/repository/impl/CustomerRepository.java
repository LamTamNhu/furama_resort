package repository.impl;

import model.Customer;
import repository.IContactRepository;
import repository.ICustomerRepository;
import utils.CsvFileReader;
import utils.CsvFileWriter;

import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final List<Customer>
    private final String PATH="src/controller/CustomerController.java";
    private void updateFromFile() {
        List<String> rawCsvFromFile = CsvFileReader.readObjectFromFile(PATH);
        if (rawCsvFromFile == null) {
            System.out.println("Can't update from empty file.");
            return;
        }
        employees = convertCsvFormatToList(rawCsvFromFile);
    }

    private void writeToFile() {
        CsvFileWriter.writeObjectToFile(convertListToCsvFormat(), PATH);
    }
    @Override
    public Object getAll() {
        return null;
    }

    @Override
    public Object findById(String id) {
        return null;
    }

    @Override
    public Object findByName(String productName) {
        return null;
    }

    @Override
    public void addEntry(Object product) {

    }

    @Override
    public void removeByID(String id) {

    }

    @Override
    public void editEntry(String id, Object product) {

    }
}
