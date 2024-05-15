package br.com.ebanx.demo.repository;

import br.com.ebanx.demo.dto.EventDto;
import br.com.ebanx.demo.model.Account;
import br.com.ebanx.demo.model.Event;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EventRepository {


    private Map<String, Account> accounts = new HashMap<>();

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Account getBalance(String accountId) {
       return getAccounts().get(accountId);
    }

    public Event createAccountWithBalance(EventDto eventDto) {

        Account account = new Account();
        account.setId(eventDto.getDestination());
        account.setBalance(eventDto.getAmount());

        accounts.put(account.getId(), account);

        Event event = new Event();
        event.setDestination(account);
        event.setType(eventDto.getType());
        return event;

    }

    public Event updateAccountWithBalance(Account account, EventDto eventDto) {

        Event event = new Event();
        event.setDestination(account);
        event.setType(eventDto.getType());
        return event;
    }

    public void reset() {
        getAccounts().clear();
    }
}
