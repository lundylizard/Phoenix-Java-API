package de.lundy.phoenix.player;

import com.google.gson.Gson;
import de.lundy.phoenix.Phoenix;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Player {

    private int id;
    private String name;
    private int level;
    private int exp;
    private int fame;
    private int job;
    private String image;
    private int restriction_flag;
    private int deleted;

    public static Player fromName(String name) throws IOException {

        Gson g = new Gson();
        URL u = new URL(Phoenix.API_ROOT + "rankings/search/" + name);
        HttpURLConnection c = (HttpURLConnection) u.openConnection();
        InputStreamReader r = new InputStreamReader(c.getInputStream());
        PlayerData d = g.fromJson(r, PlayerData.class);
        r.close();
        return d.data[0];

    }

    public static Player fromRank(int rank) throws IOException {

        Gson g = new Gson();
        URL u = new URL(Phoenix.API_ROOT + "rankings/" + Math.round(rank / 5D));
        HttpURLConnection c = (HttpURLConnection) u.openConnection();
        InputStreamReader r = new InputStreamReader(c.getInputStream());
        PlayerData d = g.fromJson(r, PlayerData.class);
        r.close();
        return d.data[(rank % 5) - 1];

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getFame() {
        return fame;
    }

    public Job getJob() {
        return new Job(job);
    }

    public String getAvatarUrl() {
        return "https://static.playphoenix.ca/avatar/" + image + ".png";
    }

    public int getRestrictionFlags() {
        return restriction_flag;
    }

    public boolean isDeleted() {
        return (deleted == 1);
    }

    public static class PlayerData {
        Player[] data;
    }

}
