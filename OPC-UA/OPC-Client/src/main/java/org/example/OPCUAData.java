package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OPCUAData {
    private String node_id;
    private String value;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNode_id() {
        return node_id;
    }

    public String getValue() {
        return value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
