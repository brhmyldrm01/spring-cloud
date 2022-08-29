package com.ibrahim.ticketservice.service;

import com.ibrahim.ticketservice.entity.Ticket;

public interface TicketNotificationService {
   void sendToQueue(Ticket ticket);
}
