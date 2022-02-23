package APis.Examen;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Utilidades {
    public Utilidades(){

    }
    public String prettyPrintResponse(Response aResponse){
        String responseBody = "";
        try{
            responseBody = aResponse.prettyPrint();

        }catch(NullPointerException npe){
            System.out.println(npe.getLocalizedMessage());
            responseBody= Constantes.NULL_RES;

        }

        return responseBody;

    }
    public HashMap<String, String> salesForceQueryParams(String aClientId, String aClienSecret, String aUserName, String aPassword){
        HashMap<String, String> aHashMap = new HashMap<String, String>();
        aHashMap.put(Constantes.GRANT_TYPE, Constantes.PASSWORD);
        aHashMap.put(Constantes.CLIENT_ID, aClientId);
        aHashMap.put(Constantes.CLIENT_SECRET, aClienSecret);
        aHashMap.put(Constantes.USERNAME, aUserName);
        aHashMap.put(Constantes.PASSWORD, aPassword);

        return aHashMap;

    }
    public Response getSalesforceToken(HashMap<String, String> aQueryParam){
        Response token = given()
                            .contentType(ContentType.JSON)
                            .queryParams(aQueryParam)
                        .when().log().all()
                            .post();

        return token;

    }
    public String getStringFromJsonArray(JSONArray aJsonArray, String aKey){
        String valueToReturn = "";

        for (int i = 0; i < aJsonArray.length(); i++) {
            try {
                JSONObject jsonObject = aJsonArray.getJSONObject(i);
                if (jsonObject.has(aKey)) {
                    valueToReturn = jsonObject.getString(aKey);

                }
            } catch (JSONException e) {
                e.printStackTrace();

            }

        }
        return valueToReturn;

    }
    public boolean stringToBoolean(String aStringToConvert){
        boolean booleanToReturn = Boolean.parseBoolean(aStringToConvert);
        return booleanToReturn;

    }
    public String booleanToString(boolean aBool){
        String boolStr = String.valueOf(aBool);
        return boolStr;
    }

}
