package com.ibrahim.accountService.service;

import com.ibrahim.accountService.entity.Account;
import com.ibrahim.accountService.repository.AccountRepository;
import com.ibrahim.client.contract.AccountDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountDto get(String id){
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        return modelMapper.map(account, AccountDto.class);
    }

    public Slice<AccountDto> getAll(Pageable pageable){
        Slice<Account> accounts = accountRepository.findAll(pageable);
        return null;
    }

    public AccountDto save(AccountDto accountDto){
        Account account = modelMapper.map(accountDto, Account.class);
        account =  accountRepository.save(account);
        accountDto.setId(account.getId());
        return accountDto ;
    }

    public AccountDto update(AccountDto accountDto, String id){
        Assert.isNull(id , "id cannot be null");
        Optional<Account> account = accountRepository.findById(id);
       Account updatedAccount =  account.map(it -> {
            it.setBirthDate(accountDto.getBirthDate());
            it.setName(accountDto.getName());
            it.setSurname(accountDto.getSurname());
            return it;
        }).orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(accountRepository.save(updatedAccount), AccountDto.class);
    }

    public void delete(String id){
        Account account = accountRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        accountRepository.delete(account);
    }


}
