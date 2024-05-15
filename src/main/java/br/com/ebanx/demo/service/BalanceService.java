package br.com.ebanx.demo.service;

import br.com.ebanx.demo.model.Account;
import br.com.ebanx.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {

    @Autowired
    EventRepository balanceRepository;


    public Account getBalance(String accountId) {
        return balanceRepository.getBalance(accountId);
    }
}
