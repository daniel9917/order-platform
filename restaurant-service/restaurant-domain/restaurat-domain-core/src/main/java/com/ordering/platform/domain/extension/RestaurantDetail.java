package com.ordering.platform.domain.extension;

import com.ordering.platform.domain.entity.BaseEntity;

import java.util.List;
import java.util.Map;

public interface RestaurantDetail {
    List< ? extends BaseEntity > getAssociatedEntities (String s);
}
