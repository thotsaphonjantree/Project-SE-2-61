package com.se.team21.backend.B5909711.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter @Setter
@ToString
@EqualsAndHashCode
@Table(name = "Test")
public class TestEntity {
    @Id
    @SequenceGenerator(name="test_seq",sequenceName="test_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="test_seq")
    @Column(name="TEST_ID",unique = true, nullable = false)

    private @NonNull Long testID;
    private @NonNull String tName;
    private @NonNull String tActivities;
    private @NonNull String tAddress;

    public TestEntity(){}

    public void setTestID(Long testID){
        this.testID = testID;
    }

    public Long getTestID(){
        return this.testID;
    }

    public void settName(String tName){
        this.tName = tName;
    }

    public String gettName(){
        return this.tName;
    }

    public void settActivities(String tActivities){
        this.tActivities = tActivities;
    }

    public String gettActivities(){
        return this.tActivities;
    }

    public void settAddress(String tAddress){
        this.tAddress = tAddress;
    }

    public String gettAddress(){
        return this.tAddress;
    }
}
