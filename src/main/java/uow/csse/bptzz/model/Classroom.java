package uow.csse.bptzz.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Create the Entity
 *
 * @author 	Eason Pan
 * @date	2017-10-16
 * @update  Tab Tu on Nov.1 2017
 * @since	1.1
 *
 * Database: pro611db
 * Username: bfa57f3b0eddae
 * Password: c759e708
 * Server: ca-cdbr-azure-central-a.cloudapp.net
 */

@Entity(name = "Classroom")
@Table(name = "bptzz_classroom")
public class Classroom {
    @Id
    private String classroom_ID;
    private String location;
    private int maxCapacity;
    private int seatsLeft;

    public String getClassroomID() { return classroom_ID; }
    public void setClassroomID(String classroomID) { this.classroom_ID = classroomID; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }
    public int getSeatsLeft() { return seatsLeft; }
    public void setSeatsLeft(int seatsLeft) { this.seatsLeft = seatsLeft; }
}