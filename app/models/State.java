package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class State
{
    @Id
    private String stateId;
    private String stateName;

    public String getStateName()
    {
        return stateName;
    }
}
