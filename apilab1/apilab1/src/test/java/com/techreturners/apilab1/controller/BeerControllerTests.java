package com.techreturners.apilab1.controller;//package definition omitted for brevity
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.
        AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.
        MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.
        MockMvcResultMatchers;
@AutoConfigureMockMvc
@SpringBootTest
public class BeerControllerTests {
    @Autowired
    private MockMvc mockMvcController;
    @Test
    public void testGetBeerLover() throws Exception {
        String expectedContent = "I like beer!";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/beerlover"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string
                        (expectedContent));
    }

    @Test
    public void testGetBeerWithoutRequestParams() throws Exception {
        String expectedValue = "leffe";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/beer"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").
                        value(expectedValue));
    }
    @Test
    public void testGetBeerWithRequestParams() throws Exception {
        String expectedValue = "dubel";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/beer").param("name",
                                "dubel"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").
                        value(expectedValue));
    }
}
