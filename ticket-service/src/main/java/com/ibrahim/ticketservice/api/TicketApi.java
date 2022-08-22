package com.ibrahim.ticketservice.api;

import com.ibrahim.ticketservice.dto.TicketDto;
import com.ibrahim.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ticket")
@RestController
@RequiredArgsConstructor
public class TicketApi {

   private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto){
     return ResponseEntity.ok(ticketService.save(ticketDto));
    }

    @PutMapping
    public ResponseEntity<TicketDto> updateTicket(@PathVariable String ticketId,
                                                  @RequestBody TicketDto ticketDto){
        return ResponseEntity.ok(ticketService.update(ticketId, ticketDto));
    }

    @GetMapping
    public ResponseEntity<Page<TicketDto>> getPagination(Pageable pageable){
        return ResponseEntity.ok(ticketService.getPagination(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getById(@PathVariable String id){
        return ResponseEntity.ok(ticketService.getById(id));
    }
}
