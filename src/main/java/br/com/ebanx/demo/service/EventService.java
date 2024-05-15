package br.com.ebanx.demo.service;

import br.com.ebanx.demo.dto.EventDto;
import br.com.ebanx.demo.model.Account;
import br.com.ebanx.demo.model.Event;
import br.com.ebanx.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public Event createEvent(EventDto eventDto) {
        if (eventRepository.getAccounts().isEmpty()) {
            // new account
            return eventRepository.createAccountWithBalance(eventDto);
        } else {
            // update account
            Account account = eventRepository.getAccounts().get(eventDto.getDestination());

            switch (eventDto.getType()) {
                case "withdraw":
                    account.setBalance(
                            account.getBalance().subtract(eventDto.getAmount())
                    );
                    break;
                case "deposit":
                    account.setBalance(
                            account.getBalance().add(eventDto.getAmount())
                    );
                    break;
                case "transfer":
                    // TODO
                    // find destination
                    // if exists repo.transfer
                    // else return null
                    break;
                default:
                    throw new RuntimeException("Invalid type");
            }

            if (eventDto.getType().equals("withdraw")){

            }
            else if (eventDto.getType().equals("deposit")){

            }

            return eventRepository.updateAccountWithBalance(account, eventDto);
        }

    }

    public void reset() {
        eventRepository.reset();
    }
}
