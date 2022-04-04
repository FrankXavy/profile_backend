package com.fxf.profile.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fxf.profile.entities.Portfolio;
import com.fxf.profile.entities.dto.PortfolioDto;
import com.fxf.profile.entities.dto.ProfileDto;
import com.fxf.profile.services.PortfolioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PortfolioControllerTest {

  @Autowired
  private MockMvc mvc;
  @MockBean
  private PortfolioService portfolioService;
  ObjectMapper objectMapper;

  @Test
  public void getById_Ok() throws Exception {

    when(portfolioService.getPortfolioById(anyLong())).thenReturn(java.util.Optional.of(new PortfolioDto()));

    mvc.perform(get("/api/portfolio/116")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void getById_IdNull() throws Exception {

    when(portfolioService.getPortfolioById(anyLong())).thenReturn(java.util.Optional.of(new PortfolioDto()));

    mvc.perform(get("/api/portfolio/null")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void getById_NoContent() throws Exception {

    when(portfolioService.getPortfolioById(anyLong())).thenReturn(java.util.Optional.empty());

    mvc.perform(get("/api/portfolio/116")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());
  }

  @BeforeEach
  void setUp() {
    objectMapper = new ObjectMapper();
  }

  @Test
  public void updatePortfolio_Ok() throws Exception {
    PortfolioDto dto = new PortfolioDto();
    dto.setId(116L);
    dto.setDescription("test");
    dto.setExperienceSummary("test");
    dto.setImageUrl("http://image");
    dto.setName("test");
    dto.setTitle("test");

    when(portfolioService.updatePortfolio(any(PortfolioDto.class))).thenReturn(java.util.Optional.of(12L));

    mvc.perform(put("/api/portfolio")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(dto)))

        .andExpect(status().isOk());
  }

  @Test
  public void updatePortfolio_IdNull() throws Exception {
    PortfolioDto dto = new PortfolioDto();
    dto.setId(null);
    dto.setDescription("test");
    dto.setExperienceSummary("test");
    dto.setImageUrl("http://image");
    dto.setName("test");
    dto.setTitle("test");

    when(portfolioService.updatePortfolio(any(PortfolioDto.class))).thenReturn(java.util.Optional.of(12L));

    mvc.perform(put("/api/portfolio")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(dto)))

        .andExpect(status().isBadRequest());
  }

  @Test
  public void updatePortfolio_NotFound() throws Exception {
    PortfolioDto dto = new PortfolioDto();
    dto.setId(116L);
    dto.setDescription("test");
    dto.setExperienceSummary("test");
    dto.setImageUrl("http://image");
    dto.setName("test");
    dto.setTitle("test");

    when(portfolioService.updatePortfolio(any(PortfolioDto.class))).thenReturn(java.util.Optional.empty());

    mvc.perform(put("/api/portfolio")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(dto)))

        .andExpect(status().isNotFound());
  }

}
