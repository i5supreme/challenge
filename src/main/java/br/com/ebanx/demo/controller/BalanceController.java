package br.com.ebanx.demo.controller;

import br.com.ebanx.demo.model.Account;
import br.com.ebanx.demo.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    @Autowired
    BalanceService balanceService;

    @GetMapping
    public ResponseEntity<BigDecimal> getBalance(@RequestParam(value = "account_id") Integer accountId) {
        Account account = balanceService.getBalance(accountId.toString());
        if (account == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(balanceService.getBalance(accountId.toString()).getBalance());
        }
    }


}
