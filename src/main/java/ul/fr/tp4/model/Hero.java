package ul.fr.tp4.model;

import javax.persistence.*;

@Entity
@Table(name = "HERO")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String faction;
    private String power;
    private float hp;

    protected Hero(){}

    public Hero( String name, String faction, String power, float hp) {
        this.name = name;
        this.faction = faction;
        this.power = power;
        this.hp = hp;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfaction() {
        return faction;
    }

    public void setfaction(String faction) {
        this.faction = faction;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }




}
