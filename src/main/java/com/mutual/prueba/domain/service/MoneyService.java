package com.mutual.prueba.domain.service;

import com.mutual.prueba.domain.entity.Money;

public interface MoneyService {

  Money save(Money money);

  Integer findAllQuantity();

  Double findAllValue();

  Integer findQuantityByValue(Double value);

  Double findValue(Double value);


}
