package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OPERATION_ROOM", schema = "HIS", catalog = "")
public class OperationRoomEntity {
    private int roomId;
    private String roomName;
    private String roomDress;
    private String roomScale;
    private String roomPhone;
    private Integer roomState;

    @Id
    @Column(name = "ROOM_ID")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "ROOM_NAME")
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Basic
    @Column(name = "ROOM_DRESS")
    public String getRoomDress() {
        return roomDress;
    }

    public void setRoomDress(String roomDress) {
        this.roomDress = roomDress;
    }

    @Basic
    @Column(name = "ROOM_SCALE")
    public String getRoomScale() {
        return roomScale;
    }

    public void setRoomScale(String roomScale) {
        this.roomScale = roomScale;
    }

    @Basic
    @Column(name = "ROOM_PHONE")
    public String getRoomPhone() {
        return roomPhone;
    }

    public void setRoomPhone(String roomPhone) {
        this.roomPhone = roomPhone;
    }

    @Basic
    @Column(name = "ROOM_STATE")
    public Integer getRoomState() {
        return roomState;
    }

    public void setRoomState(Integer roomState) {
        this.roomState = roomState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationRoomEntity that = (OperationRoomEntity) o;
        return roomId == that.roomId &&
                Objects.equals(roomName, that.roomName) &&
                Objects.equals(roomDress, that.roomDress) &&
                Objects.equals(roomScale, that.roomScale) &&
                Objects.equals(roomPhone, that.roomPhone) &&
                Objects.equals(roomState, that.roomState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, roomName, roomDress, roomScale, roomPhone, roomState);
    }

    @Override
    public String toString() {
        return "OperationRoomEntity{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", roomDress='" + roomDress + '\'' +
                ", roomScale='" + roomScale + '\'' +
                ", roomPhone='" + roomPhone + '\'' +
                ", roomState=" + roomState +
                '}';
    }
}
