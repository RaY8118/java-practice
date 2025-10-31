package com.ray8118.ipa.oops;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void testFindPlayerWithLowestRuns_existingType() {
        Player[] players = {
                new Player(1, "Alice", 50, "Batsman", "ODI"),
                new Player(2, "Bob", 30, "Batsman", "Test"),
                new Player(3, "Charlie", 40, "Bowler", "ODI")
        };
        int lowestRuns = Player.findPlayerWithLowestRuns(players, "Batsman");
        assertEquals(30, lowestRuns);
    }

    @Test
    void testFindPlayerWithLowestRuns_noPlayersOfType() {
        Player[] players = {
                new Player(1, "Alice", 50, "Batsman", "ODI"),
                new Player(2, "Bob", 30, "Bowler", "Test")
        };
        int lowestRuns = Player.findPlayerWithLowestRuns(players, "Allrounder");
        assertEquals(0, lowestRuns);
    }

    @Test
    void testFindPlayerWithLowestRuns_singlePlayer() {
        Player[] players = {
                new Player(1, "Alice", 50, "Batsman", "ODI")
        };
        int lowestRuns = Player.findPlayerWithLowestRuns(players, "Batsman");
        assertEquals(50, lowestRuns);
    }

    @Test
    void testFindPlayerByMatchType_existingMatchType() {
        Player[] players = {
                new Player(1, "Alice", 50, "Batsman", "ODI"),
                new Player(3, "Charlie", 40, "Bowler", "ODI"),
                new Player(2, "Bob", 30, "Batsman", "Test")
        };
        Player[] odiPlayers = Player.findPlayerByMatchType(players, "ODI");
        assertEquals(2, odiPlayers.length);
        assertEquals(3, odiPlayers[0].getPlayerId()); // Descending order
        assertEquals(1, odiPlayers[1].getPlayerId());
    }

    @Test
    void testFindPlayerByMatchType_noPlayersOfMatchType() {
        Player[] players = {
                new Player(1, "Alice", 50, "Batsman", "ODI"),
                new Player(2, "Bob", 30, "Batsman", "Test")
        };
        Player[] t20Players = Player.findPlayerByMatchType(players, "T20");
        assertNull(t20Players);
    }

    @Test
    void testFindPlayerByMatchType_singlePlayer() {
        Player[] players = {
                new Player(1, "Alice", 50, "Batsman", "ODI")
        };
        Player[] odiPlayers = Player.findPlayerByMatchType(players, "ODI");
        assertEquals(1, odiPlayers.length);
        assertEquals(1, odiPlayers[0].getPlayerId());
    }

    @Test
    void testFindPlayerByMatchType_emptyArray() {
        Player[] players = {};
        Player[] odiPlayers = Player.findPlayerByMatchType(players, "ODI");
        assertNull(odiPlayers);
    }
}
