package de.lundy.phoenix.player;

import com.google.gson.Gson;
import de.lundy.phoenix.Phoenix;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ranking {

    public enum RankingType {

        LEVEL, FAME, OMOK, MATCHCARD

    }

    public static class Leaderboard {

        static int current;
        boolean success;
        int prev;
        int next;
        int last;

        public static Player[] getPlayers(Ranking.RankingType rankType) throws IOException {

            Gson g = new Gson();
            URL u = new URL(Phoenix.API_ROOT + "rankings/" + (rankType.name().toLowerCase().equalsIgnoreCase("level") ? "" : rankType.name().toLowerCase() + "/") + current);
            HttpURLConnection c = (HttpURLConnection) u.openConnection();
            InputStreamReader r = new InputStreamReader(c.getInputStream());
            PlayerData d = g.fromJson(r, PlayerData.class);
            r.close();
            return d.data;

        }

        public Leaderboard getPage(int page) throws IOException {

            current = page;
            Gson g = new Gson();
            URL u = new URL(Phoenix.API_ROOT + "rankings/" + current);
            HttpURLConnection c = (HttpURLConnection) u.openConnection();
            InputStreamReader r = new InputStreamReader(c.getInputStream());
            Leaderboard d = g.fromJson(r, Leaderboard.class);
            r.close();
            return d;

        }

        public boolean isSuccess() {
            return success;
        }

        public int getPreviousPage() {
            return prev;
        }

        public void scrollToPreviousPage() {
            current -= 1;
        }

        public int getCurrentPage() {
            return current;
        }

        public boolean next() {
            return getNextPage() <= getLastPage() && isSuccess();
        }

        public int getNextPage() {
            return next;
        }

        public void scrollToNextPage() {
            current += 1;
        }

        public int getLastPage() {
            return last;
        }

        private static class PlayerData {
            Player[] data;
        }

    }

}
