package com.fish.view;

import com.fish.model.Coord;
import com.fish.model.board.GameBoard;

import com.fish.model.board.HexGameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;


public class HexBoardViewTest {

  private GameBoard board;
  private HexBoardView hbv;

  @Before
  public void setUp() throws Exception {
    this.board = new HexGameBoard(4, 5,
        Arrays.asList(new Coord(0, 1), new Coord(0, 2), new Coord(3, 3)),
        4, 1);

    this.hbv = new HexBoardView(this.board);
  }

  @Test
  public void testCalculateTopLeftCorner() {
    //We know that PIXEL_STEP is set to 50 for now
    int step = 50;
    Assert.assertEquals(step, this.hbv.calculateTopLeftXValue(0, 0));
    Assert.assertEquals(step * 15, this.hbv.calculateTopLeftXValue(3, 3));
    Assert.assertEquals(step * 37,  this.hbv.calculateTopLeftXValue(9, 12));
  }

  @Test
  public void testGetWindowDimension() {
    //We know that PIXEL_STEP is set to 50 for now
    int step = 50;
    Assert.assertEquals(new Dimension(1050, 250), this.hbv.calculateWindowSize());
  }
}