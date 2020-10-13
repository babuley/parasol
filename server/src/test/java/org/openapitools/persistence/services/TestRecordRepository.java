package org.openapitools.persistence.services;

import com.google.common.base.Splitter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openapitools.ParasolWebApplication;
import org.openapitools.persistence.model.RecordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ParasolWebApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "/application.properties")
@ActiveProfiles("database/h2")
public class TestRecordRepository {

    @Autowired
    RecordRepository recordRepository;

    private static final String[] resources = new String[]{"Anaconda"};

    @Test
    public void testAddRecord() throws Exception {
        generateRecordsOf(resources, "gas").forEach(recordDAO -> {
            this.recordRepository.save(recordDAO);
        });
        List<RecordDAO> records = this.recordRepository.findAll();

        Assert.assertEquals(records.size(),1);
        Assert.assertTrue(records.stream().filter(recordDAO -> recordDAO.getName().equals(resources[0])).findFirst().isPresent());
    }

    private List<RecordDAO> generateRecordsOf(String[] resources, String resource) {
        Random rr = new Random(1000);

        return Arrays.stream(resources).map(n -> {
            LocalDateTime when = LocalDateTime.of(2020, rr.nextInt(10), rr.nextInt(29) + 1, rr.nextInt(23), rr.nextInt(59));
            return new RecordDAO.Builder()
                    .id(rr.nextInt(10000))
                    .accountId(String.valueOf(Math.abs(rr.nextInt(100 * n.length()))))
                    .name(n)
                    .readingType(resource)
                    .value(String.valueOf(Math.abs(rr.nextInt(100 * resource.length()))))
                    .when(when)
                    .build();
        }).collect(Collectors.toList());
    }
}
