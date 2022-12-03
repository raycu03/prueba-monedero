package com.mutual.prueba.infrastructure.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mutual.prueba.MockMvcTestUtil;
import com.mutual.prueba.PruebaApplicationTests;
import com.mutual.prueba.application.MoneyApplicationService;
import com.mutual.prueba.infrastructure.dto.MoneyRequestDto;
import com.mutual.prueba.infrastructure.mapper.MoneyRequestMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(locations = "classpath:application.properties")
@WebMvcTest(controllers = { MoneyController.class})
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles(value = "dev")
@ContextConfiguration(classes = PruebaApplicationTests.class)
public class MoneyControllerTest extends MockMvcTestUtil{

  private static final String url = "/money/";
  @Mock
  private MoneyApplicationService moneyApplicationService;
  @Spy
  private MoneyRequestMapper moneyRequestMapper = Mappers.getMapper(MoneyRequestMapper.class);
  private MoneyController moneyController;

  @BeforeEach
  void init()
  {
    this.moneyController = new MoneyController(moneyApplicationService, moneyRequestMapper);
    super.init(this.moneyController);

  }


  @Test
  void saveMonedasCorrectDataThenReturnOk() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    MoneyRequestDto moneyRequestDto = new MoneyRequestDto(100d);
    MockHttpServletRequestBuilder requestBuilder = post(url)
        .contentType(MediaType.APPLICATION_JSON_VALUE);
    requestBuilder.content(mapper.writeValueAsString(moneyRequestDto));
    this.mockMvc.perform(requestBuilder).andExpect(status().isOk());

  }

  @Test
  void canitdadMonedasCorrectDataThenReturnOk() throws Exception {
    MockHttpServletRequestBuilder requestBuilder = get(url + "canitdadMonedas/")
        .contentType(MediaType.APPLICATION_JSON_VALUE);
    this.mockMvc.perform(requestBuilder).andExpect(status().isOk());

  }

  @Test
  void canitdadDineroCorrectDataThenReturnOk() throws Exception {
    MockHttpServletRequestBuilder requestBuilder = get(url + "canitdadDinero/")
        .contentType(MediaType.APPLICATION_JSON_VALUE);
    this.mockMvc.perform(requestBuilder).andExpect(status().isOk());

  }

  @Test
  void canitdadMonedasTiposCorrectDataThenReturnOk() throws Exception {
    MockHttpServletRequestBuilder requestBuilder = get(url + "canitdadMonedasTipos/"+100)
        .contentType(MediaType.APPLICATION_JSON_VALUE);
    this.mockMvc.perform(requestBuilder).andExpect(status().isOk());

  }


  @Test
  void canitdadDineroTiposCorrectDataThenReturnOk() throws Exception {
    MockHttpServletRequestBuilder requestBuilder = get(url + "canitdadDineroTipos/"+100)
        .contentType(MediaType.APPLICATION_JSON_VALUE);
    this.mockMvc.perform(requestBuilder).andExpect(status().isOk());

  }



}
