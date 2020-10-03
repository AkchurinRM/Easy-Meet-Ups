package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "freerooms")
public class FreeRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer freeId;

    public Integer getId() {
        return id;
    }

    public Integer getFreeId() {
        return freeId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFreeId(Integer freeId) {
        this.freeId = freeId;
    }
}
