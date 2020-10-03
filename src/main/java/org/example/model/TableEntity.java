package org.example.model;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "tables")
public class TableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;
    private double tableX;
    private double tableY;

    public TableEntity() {

    }

    public TableEntity(double x, double y) {
        tableX = x;
        tableY = y;
    }

    public RoomEntity getRoomEntity() {
        return roomEntity;
    }

    public void setRoomEntity(RoomEntity roomEntity) {
        this.roomEntity = roomEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTableX() {
        return tableX;
    }

    public void setTableX(double tableX) {
        this.tableX = tableX;
    }

    public double getTableY() {
        return tableY;
    }

    public void setTableY(double tableY) {
        this.tableY = tableY;
    }
}
