package com.karthik.allpocs.services;

import com.karthik.allpocs.entities.EntityOne;

import java.util.List;

public interface EntityOneService {

    public List<EntityOne> getEntityOnes();

    EntityOne getEntityOneById(int entityId);

    EntityOne addEntityOne(EntityOne entityOne);

    EntityOne editEntityOneById(int entityId, EntityOne entityOne);

    EntityOne deleteEntityOneById(int entityId);
}
