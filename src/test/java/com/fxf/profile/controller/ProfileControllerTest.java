package com.fxf.profile.controller;

import com.fxf.profile.entities.dto.ProfileDto;
import com.fxf.profile.services.ProfileService;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProfileControllerTest {

  @Autowired
  private MockMvc mvc;
  @MockBean
  private ProfileService profileService;

  @Test
  public void getById_Ok() throws Exception {

    when(profileService.getProfileById(anyLong())).thenReturn(java.util.Optional.of(new ProfileDto()));

    mvc.perform(get("/profile/116")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void getById_IdNull() throws Exception {

    when(profileService.getProfileById(anyLong())).thenReturn(java.util.Optional.of(new ProfileDto()));

    mvc.perform(get("/profile/null")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void getById_NoContent() throws Exception {

    when(profileService.getProfileById(anyLong())).thenReturn(java.util.Optional.empty());

    mvc.perform(get("/profile/116")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());
  }

  @Test
  public void getAll_Ok() throws Exception {
    when(profileService.getAll()).thenReturn(new ArrayList<>());

    mvc.perform(get("/profile")
    .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }


}
