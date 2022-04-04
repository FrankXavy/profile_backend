package com.fxf.profile.services;

import com.fxf.profile.entities.Portfolio;
import com.fxf.profile.entities.dto.ProfileDto;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

public interface ProfileService {

  Optional<ProfileDto> getProfileById(Long id);

  List<ProfileDto> getAll();
}
