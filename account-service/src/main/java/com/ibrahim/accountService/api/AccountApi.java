package com.ibrahim.accountService.api;

import com.ibrahim.accountService.service.AccountService;
import com.ibrahim.client.contract.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * localhost:8080/account
 */
@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountApi {


    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable("id") String id){
        return ResponseEntity.ok(accountService.get(id));
    }

    @GetMapping
    public ResponseEntity<Slice<AccountDto>> getAll(Pageable pageable){

        return ResponseEntity.ok(accountService.getAll(pageable));
    }


    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto accountDto){
        return ResponseEntity.ok(accountService.save(accountDto));
    }

    @PutMapping
    public ResponseEntity<AccountDto> update(@PathVariable("id") String id, @RequestBody AccountDto account){
        return ResponseEntity.ok(accountService.update(account , id));
    }

    public void delete(String id){
        accountService.delete(id);
    }

}
