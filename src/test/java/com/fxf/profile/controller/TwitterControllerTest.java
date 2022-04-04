package com.fxf.profile.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TwitterControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void getTimeline_Ok() throws Exception {

    mvc.perform(get("/tweets/timeline/philipstarritt")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$", hasSize(5)));
  }

  @Test
  public void getTimeline_NotFound() throws Exception {
      mvc.perform(get("/tweets/timeline/fxfdsfgsdfgsfdgsdfgsdfgsdfgdsfgsfdgfdsg")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isNotFound());
  }
}
