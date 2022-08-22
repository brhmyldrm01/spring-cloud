package com.ibrahim.ticketservice.Impl;

import com.ibrahim.ticketservice.dto.TicketDto;
import com.ibrahim.ticketservice.entity.PriorityType;
import com.ibrahim.ticketservice.entity.Ticket;
import com.ibrahim.ticketservice.entity.TicketStatus;
import com.ibrahim.ticketservice.entity.es.TicketModel;
import com.ibrahim.ticketservice.repository.TicketRepository;
import com.ibrahim.ticketservice.repository.es.TicketElasticRepository;
import com.ibrahim.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository ;
    private final TicketElasticRepository ticketElasticRepository ;
    private final ModelMapper modelMapper;

    @Override
    public TicketDto save(TicketDto ticketDto) {
        // Ticket entity dönüşümü
        Ticket ticket = new Ticket();

        //TODO Account API dan doğrula
        // ticket.setAssigne();

        if(StringUtils.isNotBlank(ticketDto.getDescription())){
            ticket.setDescription(ticketDto.getDescription());
        }
        else throw new IllegalArgumentException("Description Alanı Boş olamaz");

        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));

       //Mysql kaydet
        ticket = ticketRepository.save(ticket);


        //TicketModel nesnesi oluştur

       TicketModel ticketModel = TicketModel.builder().description(ticket.getDescription())
                                        .notes(ticket.getNotes())
                                        .id(ticket.getId())
                                        .priorityType(ticket.getPriorityType().getLabel())
                                        .ticketStatus(ticket.getTicketStatus().getLabel())
                                        .ticketDate(ticket.getTicketDate()).build();

        //Elastic Kaydet
        ticketElasticRepository.save(ticketModel);

        //Oluşan nesneyi döndür

        ticketDto.setId(ticket.getId());
        return ticketDto;
    }

    @Override
    public TicketDto update(String ticketId, TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String ticketId) {
        return null;
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }
}
