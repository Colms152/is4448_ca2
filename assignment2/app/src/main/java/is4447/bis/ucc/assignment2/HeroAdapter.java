package is4447.bis.ucc.assignment2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.List;
import org.json.*;


/**
 * Created by Michael Gleeson on 18/02/2021
 * Copyright (c) 2021 | gleeson.io
 */
public class HeroAdapter {


    public static final String baseURI =
            "https://gleeson.io/IS4447/HeroAPI/v1/Api.php?apicall=";

    private static final Hero convertToBeer (String beerString) {
        Gson g = new Gson();
        Hero b = g.fromJson(beerString, Hero.class);
        return b;
    }

    private static final String convertToString (Hero hero) {
        Gson g = new Gson();
        String s = g.toJson(hero);
        return s;
    }

    public static List<Hero> getHeroes () throws JsonSyntaxException, JsonProcessingException {
        String heroURI = baseURI + "getheroes";
        String heroString = HttpHandler.HttpGetExec(heroURI);

        String testString = "{\"id\":369,\"name\":\"Spiderman Johnny\",\"realname\":\"Spiderman Johnny\",\"rating\":10,\"teamaffiliation\":\"Fantastic Four\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        Hero hero = objectMapper.readValue(testString, Hero.class);
        return heroString;
    }

    public static final String getDeleteHero (int heroId) throws JsonSyntaxException {
        String heroURI = baseURI + "deletehero&id=" + heroId;
        String heroString = HttpHandler.HttpGetExec(heroURI);
        return heroString;
    }

    public static final Hero postCreateHero (Hero b) throws JsonSyntaxException, IOException {
        String heroURI = baseURI + "createhero";
        //Gson g = new Gson();
        //String payload = g.toJson(b, Hero.class);
        String payload = "name=" +b.getName()+ "&realname=" +b.getRealName()+ "&rating=" +b.getRating()+ "&teamaffiliation=" +b.getTeam();
        String heroString = HttpHandler.HttpPostExec(heroURI, payload);
        //b = g.fromJson(heroString, Hero.class);
        return b;
    }

    public static final Hero postUpdateHero (Hero b) throws JsonSyntaxException {
        String heroURI = baseURI + "updatehero&id="+b.getID();
        String payload ="id=" +b.getID()+ "&name=" +b.getName()+ "&realname=" +b.getRealName()+ "&rating=" +b.getRating()+ "&teamaffiliation=" +b.getTeam();
        String heroString = HttpHandler.HttpPostExec(heroURI, payload);
        return b;
    }

    public static final Hero putBeer (Hero b) throws JsonSyntaxException {
        String beerURI = baseURI + "beer/"+b.getID();
        Gson g = new Gson();
        String payload = g.toJson(b, Hero.class);
        //code changed here
        String beerString = HttpHandler.HttpPutExec(beerURI, payload);
        b = g.fromJson(beerString, Hero.class);
        return b;
    }

    public static final Hero deleteBeer (int beerId) throws JsonSyntaxException {
        String beerURI = baseURI + "beer/" + beerId;
        String beerString = HttpHandler.HttpDeleteExec(beerURI);
        Gson g = new Gson();
        Hero b = g.fromJson(beerString, Hero.class);
        return b;
    }
}
