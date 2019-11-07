import com.google.gson.JsonObject;
public class User {


    public int id = 545;
    public String username = "Nikitka";
    public String firstName = "Nikita";
    public String lastName = "Brikhuntsov";
    public String email = "string@gmail.com";
    public String password = "qwerty123";
    public String phone = "0123456789";
    public int userStatus = 25;

    public JsonObject convertToJson(){
        JsonObject properties = new JsonObject();

        properties.addProperty("id", id);
        properties.addProperty("username", username);
        properties.addProperty("firstName", firstName);
        properties.addProperty("lastName", lastName);
        properties.addProperty("email", email);
        properties.addProperty("password", password);
        properties.addProperty("phone", phone);
        properties.addProperty("userStatus", userStatus);

        return properties;
    }

}
