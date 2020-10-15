package com.fish.model.state;

import com.fish.model.Coord;
import com.fish.model.board.GameBoard;
import com.fish.model.tile.Tile;
import java.util.HashMap;
import java.util.List;

/**
 * Add Later
 */
public interface GameState {

  /**
   * Advances the gameStage to PLACING_PENGUINS, during which the players and GameBoard
   * are constructed.
   * @param board the board to construct for the game
   * @param players the list of players involved in the game
   */
  void initGame(GameBoard board, List<Player> players);

  /**
   * Places a penguin on a GameBoard in the PLACING_PENGUINS stage of a game by adding the
   * unique Coord and PlayerColor to the penguinLocs hashmap.
   * @param loc the coordinate location on the GameBoard
   * @param playerColor the color assigned to the Player
   */
  void placePenguin(Coord loc, PlayerColor playerColor);

  /**
   * Advances the game stage to IN_PLAY in order to enable game playing to proceed, including
   * moving penguins across the board.
   */
  void startPlay();

  /**
   * Updates the penguinLocs Hashmap to reflect the movement of penguins on the board.
   * Interpretation: Moves a penguin from one location of the visual playing board to another.
   * @param from the tile of origin
   * @param to the tile to move the penguin to
   */
  void movePenguin(Coord from, Coord to);

  /**
   *
   */
  public void advanceToNextPlayer();

  /**
   * Removes a player from the game by removing all of its penguins off the board and deleting
   * its score from the scoreKeeper field.
   * @param color the color of the player to remove
   */
  void removePlayer(PlayerColor color);

  /**
   * Determines whether there remains any valid move for any Player in the game.
   * @return a boolean which determines if the game is over
   */
  boolean isGameOver();

  /**
   * Return the GameStage emuneration that represents the current stage of the game, either
   * NOT_STARTED, PLACING_PENGUINS, IN_PLAY, or GAMEOVER.
   */
  GameStage getGameStage();

  /**
   *
   * @return
   */
  public PlayerColor getCurrentPlayer();

  /**
   * Retrieves the Tile located at the coordinate in the GameBoard.
   * @param loc the coordinate location of the desired Tile
   * @return the Tile object located there
   */
  Tile getTileAt(Coord loc);

  /**
   * Returns a HashMap of penguin locations, formatted such that the Coord is the unique
   * identifier of the location (since only one penguin can be on a tile at a time) and
   * the PlayerColor is the value, to identify which player's penguin is on that location.
   * @return a HashMap of Coord to PlayerColor values
   */
  HashMap<Coord, PlayerColor> getPenguinLocations();

  /**
   * Returns a List of all the current Coordinate locations of a single player,
   * indicated by the playerColor.
   * @param playerColor the color assigned to the player
   * @return a list of all the coordinate locations of the player's penguins
   */
  List<Coord> getOnePlayersPenguins(PlayerColor playerColor);

  /**
   * Given a specific playerColor, returns the score of that player.
   * @param playerColor the player's color
   * @return the player's score
   */
  int getPlayerScore(PlayerColor playerColor);

  /**
   * Returns the width of the game board, defined by the number of columns on the board data
   * representation.
   * @return an int with the width
   */
  int getWidth();

  /**
   * Returns the height of the game board, defined by the number of rows on the board data
   * representation.
   * @return an int with the height
   */
  int getHeight();



}