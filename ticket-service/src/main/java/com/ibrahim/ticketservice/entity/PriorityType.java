package com.ibrahim.ticketservice.entity;

import lombok.Getter;

@Getter
public enum PriorityType {
    URGENT("Acil"),
    LOW("Düşük Öncelik"),
    HIGH("Yüksek Öncelik");

    private String label;

    PriorityType(String label){
        this.label = label;
    }
}
