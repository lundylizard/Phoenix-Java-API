import de.lundy.phoenix.player.Player;
import de.lundy.phoenix.player.Ranking;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        String output = "";

        //Declaring a player
        Player player = Player.fromName("sha2048");

        //Various variables from player
        output += "-- " + player.getName() + " --\n";
        output += "> Level: " + player.getLevel() + " | EXP: " + player.getExp() + "\n";
        output += "> Job: " + player.getJob().getName() + " (" + player.getJob().getId() + ")\n";
        output += "> Fame: " + player.getFame() + "\n";
        output += "- Avatar URL: " + player.getAvatarUrl() + "\n\n";

        System.out.print(output);

        //Declaring leaderboard
        Ranking.Leaderboard lb = new Ranking.Leaderboard();

        int rank = 0;
        //get every fame leaderboard entry and display page and local rank variable
        while (lb.next()) {

            System.out.println("-- PAGE " + lb.getCurrentPage() + " --");

            for (Player players : Ranking.Leaderboard.getPlayers(Ranking.RankingType.FAME)) {

                rank++;
                System.out.println(rank + ") " + players.getName() + ": " + players.getFame());

            }

            lb.scrollToNextPage();

        }

    }

}
