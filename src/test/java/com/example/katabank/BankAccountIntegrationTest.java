package com.example.katabank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.katabank.model.TransactionType.DEPOSIT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BankAccountIntegrationTest {
    private final String API = "/api/banks/accounts";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testDeposit() throws Exception {
        mockMvc.perform(post(API + "/deposit")
                        .param("amount", "1000"))
                .andExpect(status().isOk());
    }

    @Test
    void testWithdraw() throws Exception {
        mockMvc.perform(post(API + "/deposit")
                        .param("amount", "1000"))
                .andExpect(status().isOk());

        mockMvc.perform(post(API + "/withdraw")
                        .param("amount", "500"))
                .andExpect(status().isOk());
    }

    @Test
    void testStatement() throws Exception {
        mockMvc.perform(post(API + "/deposit")
                        .param("amount", "1000"))
                .andExpect(status().isOk());

        mockMvc.perform(post(API + "/withdraw")
                        .param("amount", "500"))
                .andExpect(status().isOk());

        mockMvc.perform(get(API + "/statement"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].amount").value(1000))
                .andExpect(jsonPath("$[0].type").value("DEPOSIT"))
                .andExpect(jsonPath("$[0].balance").value(1000))
                .andExpect(jsonPath("$[1].amount").value(500))
                .andExpect(jsonPath("$[1].type").value("WITHDRAWAL"))
                .andExpect(jsonPath("$[1].balance").value(500));
    }
}
