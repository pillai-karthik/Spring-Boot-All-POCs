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
}
