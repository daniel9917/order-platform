package com.ordering.platform.saga;

import com.ordering.platform.domain.event.DomainEvent;

public interface SagaStep <T, S extends DomainEvent, U extends DomainEvent>{
    S process (T data);
    U rollabck (T data);
}