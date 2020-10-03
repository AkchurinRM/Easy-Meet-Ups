package org.example.model;

import org.example.objects.User;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "chests")
public class ChestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer chestId;
    private Double chestX;
    private Double chestY;
    private Boolean free;
    private String userName;
    private String userDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;

    public ChestEntity(){}

    public ChestEntity(Integer chI, Double chX, Double chY, Boolean fr, String uN, String uD){
        chestId = chI;
        chestX = chX;
        chestY = chY;
        free = fr;
        userName = uN;
        userDescription = uD;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChestId() {
        return chestId;
    }

    public void setChestId(Integer chestId) {
        this.chestId = chestId;
    }

    public Double getChestX() {
        return chestX;
    }

    public void setChestX(Double chestX) {
        this.chestX = chestX;
    }

    public Double getChestY() {
        return chestY;
    }

    public void setChestY(Double chestY) {
        this.chestY = chestY;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public RoomEntity getRoomEntity() {
        return roomEntity;
    }

    public void setRoomEntity(RoomEntity roomEntity) {
        this.roomEntity = roomEntity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }
}
