package is4447.bis.ucc.assignment2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.ArrayList;
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
        int strlength = heroString.length();
        String jsonarray  = heroString.substring(68, strlength-2);
        String[] jsonheros = jsonarray.split("},");
        System.out.println(jsonheros.length);
        for (int i = 0; i <= jsonheros.length-2; i++) {
            jsonheros[i] = jsonheros[i].concat("}");
        }
        System.out.println(jsonheros[0]+"  "+jsonheros[1]);
        List<Hero> heroes = new ArrayList<Hero>();
        //String testString = "{\"id\":369,\"name\":\"Spiderman Johnny\",\"realname\":\"Spiderman Johnny\",\"rating\":10,\"teamaffiliation\":\"Fantastic Four\"}";
        //ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        //Hero hero = JsonToObject.getHeroObject(testString);
        //Hero hero = objectMapper.readValue(testString, Hero.class);
        for(String strhero : jsonheros) {
            Hero hero = JsonToObject.getHeroObject(strhero);
            heroes.add(hero);
        }
        return heroes;
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
        String payload = "name=" +b.getName()+ "&realname=" +b.getRealname()+ "&rating=" +b.getRating()+ "&teamaffiliation=" +b.getTeamaffiliation();
        String heroString = HttpHandler.HttpPostExec(heroURI, payload);
        //b = g.fromJson(heroString, Hero.class);
        return b;
    }

    public static final Hero postUpdateHero (Hero b) throws JsonSyntaxException {
        String heroURI = baseURI + "updatehero&id="+b.getId();
        String payload ="id=" +b.getId()+ "&name=" +b.getName()+ "&realname=" +b.getRealname()+ "&rating=" +b.getRating()+ "&teamaffiliation=" +b.getTeamaffiliation();
        String heroString = HttpHandler.HttpPostExec(heroURI, payload);
        return b;
    }

    public static final Hero putBeer (Hero b) throws JsonSyntaxException {
        String beerURI = baseURI + "beer/"+b.getId();
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
