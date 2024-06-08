package com.psps.petclinic.services.map;

import com.psps.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

    protected Map<Long,T> map = new HashMap<>();
    T save(T object){
        if(object!=null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(),object);
        }
        else {
            throw new RuntimeException("Object Cannot be null");
        }

        return object;
    }
    T findById(ID id){
        return map.get(id);
    }
    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    void delete(T object){
        map.entrySet().removeIf(obj ->obj.getValue().equals(object));
    }

    void deleteById(ID id){
        map.remove(id);
    }

    private Long getNextId(){
        Long nextId = null;
                try{
                    nextId = Collections.max(map.keySet())+1;
                }catch (NoSuchElementException e){
                    nextId = 1l;
                }
                return nextId;
    }

}
