package com.karthik.allpocs.services;

import com.karthik.allpocs.entities.EntityOne;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntityOneServiceImpl implements EntityOneService{

    List<EntityOne> entityOneList;

    public EntityOneServiceImpl() {
        entityOneList = new ArrayList<>();
        entityOneList.add(new EntityOne("attributeOneValue1",1));
        entityOneList.add(new EntityOne("attributeOneValue2",2));
    }

    @Override
    public List<EntityOne> getEntityOnes() {
        return entityOneList;
    }

    @Override
    public EntityOne getEntityOneById(int entityId) {

        if(entityOneList.size()>entityId) {
            return entityOneList.get(entityId);
        }else{
            return null;
        }
    }

    @Override
    public EntityOne addEntityOne(EntityOne entityOne) {
        entityOneList.add(entityOne);
        return entityOne;
    }

    @Override
    public EntityOne editEntityOneById(int entityId, EntityOne entityOneNew) {
        entityOneList.set(entityId,entityOneNew);
        return entityOneNew;
    }

    @Override
    public EntityOne deleteEntityOneById(int entityId) {
        EntityOne deletedEntityOne = entityOneList.get(entityId);
        entityOneList.remove(entityId);
        return deletedEntityOne;
    }
}
