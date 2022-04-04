package com.fxf.profile.controller;

import com.fxf.profile.entities.dto.PortfolioDto;
import com.fxf.profile.services.PortfolioService;
import java.util.Optional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/portfolio")
@NoArgsConstructor
public class PortfolioController {

  private PortfolioService portfolioService;

  @Autowired
  public PortfolioController(PortfolioService portfolioService) {
    this.portfolioService = portfolioService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<PortfolioDto> getById(@PathVariable(value = "id") Long id) {
    if ( id != null ) {
      Optional<PortfolioDto> OptPortfolio = portfolioService.getPortfolioById(id);
      if (OptPortfolio.isPresent()) {
        return new ResponseEntity(OptPortfolio.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
      }
    } else {
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping
  public ResponseEntity<Long> updateProfile(@RequestBody PortfolioDto portfolioDto) {
    if (portfolioDto.getId() != null) {
      Optional<Long> result = portfolioService.updatePortfolio(portfolioDto);
      if (result.isPresent()) {
        return new ResponseEntity<Long>(result.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
      }
    } else {
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
  }
}
