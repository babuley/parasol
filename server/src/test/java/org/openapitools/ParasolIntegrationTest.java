package org.openapitools;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openapitools.ParasolWebApplication;
import org.openapitools.model.Record;
import org.openapitools.persistence.model.RecordDAO;
import org.openapitools.persistence.services.RecordRepository;
import org.openapitools.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ParasolWebApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "/application.properties")
@ActiveProfiles("database/h2")
public class ParasolIntegrationTest {

    @Autowired
    private MockMvc mock;

    @MockBean
    private RecordService recordService;

    @Autowired
    private RecordRepository recordRepository;

    @Test
    public void testRecordingData()
            throws Exception {

        Record r = new Record();
        r.value("10");
        r.customerId("customer12");
        r.readingType("gas");
        r.accountId("account123");

        ObjectMapper objectMapper = new ObjectMapper();
        mock.perform(post("/api/v1/records")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(r)
                )
        ).andExpect(status().isOk());

        mock.perform(get("/api/v1/records")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        mock.perform(post("/api/v1/records")
                .contentType(MediaType.APPLICATION_JSON)
                .content("")
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void testDataFetch() throws Exception {
        mock.perform(get("/api/v1/records"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        mock.perform(get("/api/v1/records")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        mock.perform(get("/api/v2/records"))
                .andDo(print()).andExpect(status().isNotFound());
    }

}