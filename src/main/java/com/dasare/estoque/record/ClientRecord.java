package com.dasare.estoque.record;

import com.dasare.estoque.model.Manager;

public record ClientRecord(Long clientID,String name,String enderco, Manager manager) {

}
