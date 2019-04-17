package com.firstdata.iteiris.bulkao.test;

import com.firstdata.iteiris.bulkao.pojo.Customer;
import com.firstdata.iteiris.bulkao.pojo.Header;
import com.firstdata.iteiris.bulkao.pojo.Trailer;
import com.firstdata.iteiris.bulkao.test.mock.CustomerMockFactory;
import com.zandero.ffpojo.FFPojoHelper;
import com.zandero.ffpojo.exception.FFPojoException;
import com.zandero.ffpojo.file.reader.FileSystemFlatFileReader;
import com.zandero.ffpojo.file.reader.FlatFileReader;
import com.zandero.ffpojo.file.reader.FlatFileReaderDefinition;
import com.zandero.ffpojo.file.reader.RecordType;
import com.zandero.ffpojo.file.writer.FileSystemFlatFileWriter;
import com.zandero.ffpojo.file.writer.FlatFileWriter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ReadWriteBulkaoTest {

    private static final String OUTPUT_TXT_OS_PATH = System.getProperty("java.io.tmpdir") + "SimpleFileSystemFlatFileWriterExample.txt";
    private static final String FILE_NAME = "bulkao_example/FileSystemFlatFileReaderWithHeaderAndTrailerExample.txt";

    private FFPojoHelper helper;

    @Test
    public void readCustomersTest() {
        try {
            System.out.println("Making POJO from file system TXT FILE...");
            readCustomers();
            System.out.println("END !");
        } catch (IOException | FFPojoException e) {
            e.printStackTrace();
        }
    }

    private void readCustomers() throws IOException, FFPojoException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File inputFile = new File(classLoader.getResource(FILE_NAME).getFile());

        if (!inputFile.exists()) {
            throw new IllegalStateException("File not found: " + inputFile.getAbsolutePath());
        }
        FlatFileReaderDefinition ffDefinition = new FlatFileReaderDefinition(Customer.class);
        ffDefinition.setHeader(Header.class);
        ffDefinition.setTrailer(Trailer.class);
        FlatFileReader ffReader = new FileSystemFlatFileReader(inputFile, ffDefinition);

        ffReader.forEach(record -> {
            RecordType recordType = ffReader.getRecordType();
            if (recordType == RecordType.HEADER) {
                System.out.print("HEADER FOUND: ");
                Header header = (Header) record;
                System.out.printf("[%d][%s]\n", header.getControlNumber(), header.getProcessDate());
            } else if (recordType == RecordType.BODY) {
                Customer cust = (Customer) record;
                System.out.printf("[%d][%s][%s]\n", cust.getId(), cust.getName(), cust.getEmail());
            } else if (recordType == RecordType.TRAILER) {
                System.out.print("TRAILER FOUND: ");
                Trailer trailer = (Trailer) record;
                System.out.printf("[%d]\n", trailer.getRecordsCount());
            }
        });
        ffReader.close();
    }

    @Test
    public void writeCustomersTest() {
        this.helper = FFPojoHelper.getInstance();
        Header header = new Header();

        header.setControlNumber(123L);
        header.setProcessDate(new Date());

        String s1 = this.helper.parseToText(header);

        System.out.println(s1);

        List<Customer> customers = CustomerMockFactory.createCustomersMockList();
        customers.forEach(customer -> {
            String s = this.helper.parseToText(customer);

            System.out.println(s);
        });

        Trailer trailer = new Trailer();

        trailer.setRecordsCount(3);

        System.out.println(this.helper.parseToText(trailer));

    }

}
