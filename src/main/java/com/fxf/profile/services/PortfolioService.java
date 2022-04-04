package com.fxf.profile.services;

import com.fxf.profile.entities.dto.PortfolioDto;
import com.fxf.profile.entities.dto.ProfileDto;
import java.util.Optional;

public interface PortfolioService {

  Optional<PortfolioDto> getPortfolioById(Long id);

  Optional<Long> updatePortfolio(PortfolioDto profileDto);

}
