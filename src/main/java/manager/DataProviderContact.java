package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess(){//without randoms!!
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Cristiano")
                .lastName("Ronaldo")
                .phone("5555555777")
                .email("cristiano@gmail.com")
                .address("Portugal,Lisbon")
                .description("all fields")
                .build()
        });
        list.add(new Object[]{Contact.builder()
                .name("CristianoReq")
                .lastName("Ronaldo")
                .phone("5555555222")
                .email("cristiano@gmail.com")
                .address("Portugal,Lisbon")
                .build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactWrongPhone() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                Contact.builder()
                        .name("Cristiano")
                        .lastName("Ronaldo")
                        .phone("123")
                        .email("cristiano@gmail.com")
                        .address("Portugal,Lisbon")
                        .description("wrong phone")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Cristiano")
                        .lastName("Ronaldo")
                        .phone("123456789012345678")
                        .email("cristiano@gmail.com")
                        .address("Portugal,Lisbon")
                        .description("wrong phone")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Cristiano")
                        .lastName("Ronaldo")
                        .phone("rtyttgrtyytrg")
                        .email("cristiano@gmail.com")
                        .address("Portugal,Lisbon")
                        .description("wrong phone")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Cristiano")
                        .lastName("Ronaldo")
                        .phone("")
                        .email("cristiano@gmail.com")
                        .address("Portugal,Lisbon")
                        .description("wrong phone")
                        .build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] all = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(all[0])
                    .lastName(all[1])
                    .email(all[2])
                    .phone(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()
            });
            line = reader.readLine();
        }
        return list.iterator();
    }
}
