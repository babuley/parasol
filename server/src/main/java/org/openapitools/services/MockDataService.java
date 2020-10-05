package org.openapitools.services;

import org.openapitools.persistence.model.RecordDAO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class MockDataService implements IMockDataService {

    private final String[] a = new String[]{"Smith","Jones", "Williams","Morris","Button", "Rook","Wilson"};

    @Override
    public List<RecordDAO> generateRecordsOf(String resource) {
            Random rr = new Random(1000);

            return Arrays.stream(a).map(n -> {
                RecordDAO r = new RecordDAO();
                r.setAccountId(String.valueOf(Math.abs(rr.nextInt(100 * n.length()))));
                r.setName(n);
                r.setReadingType(resource);
                r.setValue(String.valueOf(Math.abs(rr.nextInt(100* resource.length()))));
                r.setWhen(LocalDateTime.now());
                return r;
            }).collect(Collectors.toList());
        }
    }

