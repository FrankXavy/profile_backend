package com.fxf.profile.services;

import com.fxf.profile.entities.Portfolio;
import com.fxf.profile.entities.dto.PortfolioDto;
import com.fxf.profile.repository.PortfolioRepository;
import java.util.Optional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {

  private PortfolioRepository portfolioRepository;

  @Autowired
  public PortfolioServiceImpl(PortfolioRepository portfolioRepository) {
    this.portfolioRepository = portfolioRepository;
  }

  @Override
  public Optional<PortfolioDto> getPortfolioById(Long id) {
    Optional<Portfolio> result = portfolioRepository.findById(id);
    if (result.isPresent()) {
      Portfolio portfolio = result.get();
      return Optional.of(mapToPortfolioDto(portfolio));
    } else {
      return Optional.empty();
    }
  }

  private PortfolioDto mapToPortfolioDto(Portfolio portfolio) {
    PortfolioDto dto = PortfolioDto.builder()
        .id(portfolio.getId())
        .address(portfolio.getAddress())
        .description(portfolio.getDescription())
        .email(portfolio.getEmail())
        .experience(portfolio.getExperience())
        .experienceSummary(portfolio.getExperienceSummary())
        .imagePath(portfolio.getImagePath())
        .imageUrl(portfolio.getImageUrl())
        .name(portfolio.getName())
        .names(portfolio.getNames())
        .phone(portfolio.getPhone())
        .title(portfolio.getTitle()).build();
    return dto;
  }

  @Override
  public Optional<Long> updatePortfolio(PortfolioDto portfolioDto) {
    Optional<Portfolio> optPortfolio = portfolioRepository.findById(portfolioDto.getId());
    if (optPortfolio.isPresent()) {
      Portfolio portfolio = optPortfolio.get();
      mapToPortfolio(portfolioDto, portfolio);
      portfolioRepository.save(portfolio);
      return Optional.ofNullable(portfolio.getId());
    } else {
      return Optional.empty();
    }
  }

  private void mapToPortfolio(PortfolioDto dto, Portfolio portfolio) {
    portfolio.setDescription(dto.getDescription());
    portfolio.setExperienceSummary(dto.getExperienceSummary());
    portfolio.setImageUrl(dto.getImageUrl());
    portfolio.setName(dto.getName());
    portfolio.setTitle(dto.getTitle());
    portfolio.setTitle(dto.getTitle());
    portfolio.setExperience(dto.getExperience());
    portfolio.setAddress(dto.getAddress());
    portfolio.setEmail(dto.getEmail());
    portfolio.setNames(dto.getNames());
    portfolio.setPhone(dto.getPhone());
    portfolio.setTwitterUser(dto.getTwitterUser());
    portfolio.setTwitterUserId(dto.getTwitterUserId());
    portfolio.setImagePath(dto.getImagePath());
    portfolio.setZipCode(dto.getZipCode());
  }
}
