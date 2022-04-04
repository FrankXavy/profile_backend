package com.fxf.profile.services;

import com.fxf.profile.entities.Portfolio;
import com.fxf.profile.entities.dto.ProfileDto;
import com.fxf.profile.repository.PortfolioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{

  private PortfolioRepository portfolioRepository;

  @Autowired
  public ProfileServiceImpl(PortfolioRepository repository) {
    this.portfolioRepository = repository;
  }

  @Override
  public Optional<ProfileDto> getProfileById(Long id) {
    Optional<Portfolio> optPortfolio = portfolioRepository.findById(id);
    if (optPortfolio.isPresent()) {
      Portfolio portfolio = optPortfolio.get();
      ProfileDto dto = new ProfileDto();
      mapPortfolioToProfile(dto, portfolio);
      return Optional.of(dto);
    } else {
      return Optional.empty();
    }
  }

  private ProfileDto mapPortfolioToProfile(ProfileDto dto, Portfolio portfolio) {
    dto.setId(portfolio.getId());
    dto.setDescription(portfolio.getDescription());
    dto.setExperienceSummary(portfolio.getExperienceSummary());
    dto.setName(portfolio.getName());
    dto.setImageUrl(portfolio.getImageUrl());
    dto.setTitle(portfolio.getTitle());
    dto.setExperience(portfolio.getExperience());
    dto.setNames(portfolio.getNames());
    dto.setTwitterUser(portfolio.getTwitterUser());
    dto.setTwitterUserId(portfolio.getTwitterUserId());
    return dto;
  }

  @Override
  public List<ProfileDto> getAll() {
    List<ProfileDto> result = new ArrayList<>();
    List<Portfolio> portfolios = portfolioRepository.findAll();
    for(Portfolio p: portfolios) {
      ProfileDto dto = new ProfileDto();
      result.add(mapPortfolioToProfile(dto, p));
    }

    return result;
  }
}
