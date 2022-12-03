package com.mutual.prueba.application;

import com.mutual.prueba.domain.entity.Money;

public interface MoneyApplicationService {

  Money save(Money money);

  Integer findAllQuantity();

  Double findAllValue();

  Integer findQuantityByValue(Double value);

  Double findValue(Double value);


}
