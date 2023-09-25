package com.ordering.platform.domain.event;

public interface DomainEvent <T>{
    void fire();
}
