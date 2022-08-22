package com.ibrahim.ticketservice.repository.es;

import com.ibrahim.ticketservice.entity.es.TicketModel;
import org.elasticsearch.client.ElasticsearchClient;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel, String> {

}
