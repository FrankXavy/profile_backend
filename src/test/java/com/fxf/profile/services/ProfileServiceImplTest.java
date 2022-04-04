package com.fxf.profile.services;

import com.fxf.profile.entities.Portfolio;
import com.fxf.profile.entities.dto.ProfileDto;
import com.fxf.profile.repository.PortfolioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest
public class ProfileServiceImplTest {

  @MockBean
  private PortfolioRepository portfolioRepository;

  @Autowired
  private ProfileService handler;

  @Test
  public void getProfileById_Ok() {
    Portfolio portfolio = Portfolio.builder().id(12L).build();
    Mockito.when(portfolioRepository.findById(anyLong())).thenReturn(Optional.of(portfolio));

    Optional<ProfileDto> result= handler.getProfileById(anyLong());
    Assert.isTrue(portfolio.getId().equals(result.get().getId()), "Ok");
  }

  @Test
  public void getProfileById_NotFound() {
    Mockito.when(portfolioRepository.findById(anyLong())).thenReturn(Optional.empty());

    Optional<ProfileDto> result= handler.getProfileById(anyLong());
    Assert.isTrue(!result.isPresent() , "Ok");
  }

  @Test
  public void getAll_Ok() {
    Mockito.when(portfolioRepository.findAll()).thenReturn(new ArrayList<>());

    List<ProfileDto> result = handler.getAll();
    Assert.isTrue(result.isEmpty());
  }
}
