package is4447.bis.ucc.assignment2;

import com.google.gson.Gson;

public class JsonToObject {


    public static Hero getHeroObject(String HeroJson)
    {
        // Storing preprocessed json(Added slashes)
        //String HeroJson
         //       = "{\"id\":369,\"name\":\"Spiderman Johnny\",\"realname\":\"Spiderman Johnny\",\"rating\":10,\"teamaffiliation\":\"Fantastic Four\"}";

        // Creating a Gson Object
        Gson gson = new Gson();

        // Converting json to object
        // first parameter should be prpreocessed json
        // and second should be mapping class
        Hero hero
                = gson.fromJson(HeroJson,
                Hero.class);

        // return object
        return hero;
    }
}