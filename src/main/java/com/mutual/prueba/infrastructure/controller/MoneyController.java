package com.mutual.prueba.infrastructure.controller;

import com.mutual.prueba.application.MoneyApplicationService;
import com.mutual.prueba.domain.entity.Money;
import com.mutual.prueba.infrastructure.dto.MoneyRequestDto;
import com.mutual.prueba.infrastructure.mapper.MoneyRequestMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/money", produces = MediaType.APPLICATION_JSON_VALUE)
public class MoneyController {


  private final MoneyApplicationService moneyApplicationService;
  private final MoneyRequestMapper moneyRequestMapper;

  @PostMapping("/")
  public void save(@RequestBody MoneyRequestDto money) {
     moneyApplicationService.save(moneyRequestMapper.toEntity(money));
  }

  @GetMapping("/canitdadMonedas")
  public Integer findAllQuantity() {
    return moneyApplicationService.findAllQuantity();
  }

  @GetMapping("/canitdadDinero")
  public Double findAllValue() {
    return moneyApplicationService.findAllValue();
  }

  @GetMapping("/canitdadMonedasTipos/{value}")
  public Integer findQuantityByValue(@PathVariable Double value) {
    return moneyApplicationService.findQuantityByValue(value);
  }

  @GetMapping("/canitdadDineroTipos/{value}")
  public Double findValue(@PathVariable Double value) {
    return moneyApplicationService.findValue(value);
  }
}
