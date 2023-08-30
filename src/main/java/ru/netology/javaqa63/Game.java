package ru.netology.javaqa63;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int findByName(String name) {
        int result;
        for (Player player : players) {
            if (player.getName().equals(name)) {
                result = player.getStrength();
                return result;
            }
        }
        return 0;
    }





    public int round(String playerName1, String playerName2) {
        int strengthPlayer1 = findByName(playerName1);
        int strengthPlayer2 = findByName(playerName2);
        if (strengthPlayer1 == 0) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not registered"
            );
        }
        if (strengthPlayer2 == 0) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName2 + " not registered"
            );
        }
        if (strengthPlayer1 > strengthPlayer2) {
            return 1;// победа 1
        } else if (strengthPlayer1 < strengthPlayer2) {
            return 2;// победа 2
        } else {
            return 0;//ничья
        }
    }

}
