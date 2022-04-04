package com.fxf.profile.controller;

import com.fxf.profile.entities.dto.ProfileDto;
import com.fxf.profile.services.ProfileService;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.PushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
@CrossOrigin
public class ProfileController {

  private ProfileService profileService;

  @Autowired
  public ProfileController(ProfileService service) {
    this.profileService = service;
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProfileDto> getById(@PathVariable(value = "id") Long id) {
    if ( id != null ) {
      Optional<ProfileDto> OptProfile = profileService.getProfileById(id);
      if (OptProfile.isPresent()) {
        return new ResponseEntity(OptProfile.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
      }
    } else {
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping
  public ResponseEntity<List<ProfileDto>> getAll() {
    return new ResponseEntity(profileService.getAll(), HttpStatus.OK);
  }


}
