// Create a class Player with below attributes:
// playerld - int
// playerName - String
// nms - int
// playerType - Sting
// matchType - String
// The above attributes should be private, mite getters, setters and
// parameterized constructor as required.
// Crate class Solution with main method.
// Implement two static methods - findPIayerWithLowestRuns and
// findPlayerByMatchType in Solution class.
// findPlayerW1thLowestRuns method:
// This method will take array of Player objects and a String value as
// input parameters.
// The method will retum the least runs of the Player from array of
// Player objects for the given player type.
// (String parameter passed). If no Player with the above condition are
// present in array of Player objects,
// then the method should return O.
// findPlayerByMatchType method:
// This method will take array of Player objects and String value as
// input parameters and retum the an-ay of Player objects
// belonging to the match type passed as input parameter in
// Descending order of playerld.
// If no Player with the above condition are present in the an-ay of
// Player objects, then the method should retum null.
//
package com.ray8118.ipa.oops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Player {

    private int playerId;
    private String playerName;
    private int runs;
    private String playerType;
    private String matchType;

    public Player() {
    }

    public Player(int playerId, String playerName, int runs, String playerType, String matchType) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.runs = runs;
        this.playerType = playerType;
        this.matchType = matchType;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public static int findPlayerWithLowestRuns(Player[] players, String playerType) {
        Player leastRunPlayer = null;
        for (Player player : players) {
            if (player.getPlayerType().equals(playerType)) {
                if (leastRunPlayer == null || player.getRuns() < leastRunPlayer.getRuns()) {
                    leastRunPlayer = player;
                }
            }
        }

        return leastRunPlayer == null ? 0 : leastRunPlayer.getRuns();
    }

    public static Player[] findPlayerByMatchType(Player[] players, String matchType) {
        List<Player> matchedPlayers = new ArrayList<>();
        for (Player player : players) {
            if (player.getMatchType().equals(matchType)) {
                matchedPlayers.add(player);
            }
        }

        Player[] sortedPlayers = matchedPlayers.toArray(new Player[0]);
        // for (int i = 0; i < sortedPlayers.length - 1; i++) {
        // for (int j = 0; j < sortedPlayers.length - i - 1; j++) {
        // if (sortedPlayers[j].getPlayerId() < sortedPlayers[j + 1].getPlayerId()) {
        // Player temp = sortedPlayers[j];
        // sortedPlayers[j] = sortedPlayers[j + 1];
        // sortedPlayers[j + 1] = temp;
        // }
        // }
        // }

        Arrays.sort(sortedPlayers, Comparator.comparingInt(Player::getPlayerId).reversed());
        return sortedPlayers.length == 0 ? null : sortedPlayers;
    }

}
