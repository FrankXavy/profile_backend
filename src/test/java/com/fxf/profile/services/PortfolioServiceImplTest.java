package com.fxf.profile.services;

import com.fxf.profile.entities.Portfolio;
import com.fxf.profile.entities.dto.PortfolioDto;
import com.fxf.profile.entities.dto.ProfileDto;
import com.fxf.profile.repository.PortfolioRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;

@SpringBootTest
public class PortfolioServiceImplTest {

  @MockBean
  private PortfolioRepository portfolioRepository;

  @Autowired
  private PortfolioService handler;

  @Test
  public void getPortfolioById_Ok() {
    Portfolio portfolio = Portfolio.builder().id(12L).build();
    Mockito.when(portfolioRepository.findById(anyLong())).thenReturn(Optional.of(portfolio));

    Optional<PortfolioDto> result= handler.getPortfolioById(anyLong());
    Assert.isTrue(portfolio.getId().equals(result.get().getId()), "Ok");
  }

  @Test
  public void getPortfolioById_NotFound() {
    Mockito.when(portfolioRepository.findById(anyLong())).thenReturn(Optional.empty());

    Optional<PortfolioDto> result= handler.getPortfolioById(anyLong());
    Assert.isTrue(!result.isPresent() , "Ok");
  }

  @Test
  public void updatePortfolio_Ok() {
    PortfolioDto dto = PortfolioDto.builder()
        .id(116L)
        .description("test")
        .experienceSummary("test")
        .imageUrl("test")
        .name("test")
        .title("test").build();

    Portfolio result = Portfolio.builder().id(12L).build();

    Mockito.when(portfolioRepository.findById(anyLong())).thenReturn(Optional.of(new Portfolio()));
    Mockito.when(portfolioRepository.save(any(Portfolio.class))).thenReturn(result);
    handler.updatePortfolio(dto);

    Mockito.verify(portfolioRepository, times(1)).save(any(Portfolio.class));
  }

  @Test
  public void updatePortfolio_NotFound() {
    PortfolioDto dto = PortfolioDto.builder()
        .id(116L)
        .description("test")
        .experienceSummary("test")
        .imageUrl("test")
        .name("test")
        .title("test").build();

    Mockito.when(portfolioRepository.findById(anyLong())).thenReturn(Optional.empty());
    Optional<Long> result = handler.updatePortfolio(dto);
    Assert.isTrue(result.isEmpty());

  }

}
