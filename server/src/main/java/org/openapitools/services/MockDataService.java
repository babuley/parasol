package org.openapitools.services;

import org.openapitools.persistence.model.RecordDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.google.common.base.Splitter;
import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class MockDataService implements IMockDataService {

    @Value("${com.parasol.mockdata.names:}")
    String mockDataNames;

    @Override
    public List<RecordDAO> generateRecordsOf(String resource) {
            Random rr = new Random(1000);

            return getMockNames().stream().map(n -> {
                LocalDateTime when = LocalDateTime.of(2020,rr.nextInt(10),rr.nextInt(29)  +1, rr.nextInt(23), rr.nextInt(59));
                Timestamp timestamp = Timestamp.valueOf(when);
                return new RecordDAO.Builder()
                        .id(rr.nextInt(10000))
                        .accountId(String.valueOf(Math.abs(rr.nextInt(100 * n.length()))))
                        .name(n)
                        .readingType(resource)
                        .value(String.valueOf(Math.abs(rr.nextInt(100* resource.length()))))
                        .when(timestamp)
                .build();
            }).collect(Collectors.toList());
    }

    private Collection<String> getMockNames(){
        checkNotNull(mockDataNames);
        Iterable<String> chunks = Splitter.on(",").omitEmptyStrings().split(mockDataNames);
        return StreamSupport.stream(chunks.spliterator(), false)
                .collect(Collectors.toList());
    }

}

