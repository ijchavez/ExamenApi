package APis.Examen;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Constantes {
    public static String REQRES_IN_URL = "https://reqres.in/api/";
    public static String API_BOOKS_URL = "https://simple-books-api.glitch.me/";
    public static RequestSpecification REQ_SPEC = RestAssured.given();

    public static String NULL_RES = "The response is null";

    public static String GRANT_TYPE = "grant_type";
    public static String PASSWORD = "password";
    public static String CLIENT_ID = "client_id";
    public static String CLIENT_SECRET = "client_secret";
    public static String USERNAME = "username";

    public static String SF_CLIENT_ID = "3MVG9p1Q1BCe9GmCwmEafpiSuTjK9mcfSEvB3Gc.PF460wZqo.Y6YzYz7i0nUG70TapcDYxo7PZkWiqouXOzl";
    public static String SF_CLIENT_SECRET = "B62795D46F0EFE9EF21469AF24A126DBC0C09FA7B95884E4D1C49A025FEF8410";
    public static String SF_USERNAME = "lhood@banshee.com";
    public static String SF_PASSWORD = "Zz.1121224421";
    public static String SF_SECURITY_TOKEN = "HRqKgyiRLXmLoc4Q6iAi2RJS";
    public static String SF_API_TOKEN = SF_PASSWORD + SF_SECURITY_TOKEN; //este es el que se usa ahora
    public static String ACCESS_TOKEN = "";
    public static String INSTANCE_URL = "";
    public static String TOKEN_TYPE = "";
    public static String SALESFORCE_BASE_LOGIN = "https://login.salesforce.com/services/";
    public static String SALESFORCE_BASE_TOKEN = "oauth2/token";
    //public static String SALESFORCE_SERVICES = "/services/data/v51.0/sobjects/";
    public static String SALESFORCE_VERSION_PATH = "services/data/v51.0/";
    public static String SOBJECTS = "sobjects/";

    public static String CAMPAIGN = "campaign/";

}
