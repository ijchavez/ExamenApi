package APis.Examen.APis;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Campaign {
    boolean isActive;
    String name;
    String status;

    public Campaign(boolean aIsActive, String aName, String status) {
        this.isActive = aIsActive;
        this.name = aName;
        this.status = status;

    }
    public String toString(){
        return "Campaign: " + this.name;

    }

}
