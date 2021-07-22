package com.ob.rover2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverExecution {

   static Rovers rover;

    @BeforeEach
    public void init(){
        Rovers.Grid grid = new Rovers.Grid();
        rover = new Rovers(grid);
    }
    @ParameterizedTest
    @CsvSource({"R, 0:0:E", "RR, 0:0:S", "RRRR, 0:0:N"})
    public void roverRotatesRight(String command, String position){
        assertThat(rover.execute(command)).isEqualTo(position);
    }

    @ParameterizedTest
    @CsvSource({"L, 0:0:W", "LL, 0:0:S", "LLL, 0:0:E"})
    public void roverRotatesLeft(String command, String position){
        assertThat(rover.execute(command)).isEqualTo(position);
    }


    @ParameterizedTest
    @CsvSource({"RRR, 0:0:W"})
    public void dummy(String command, String position){
        assertThat(rover.execute(command)).isEqualTo(position);
    }

    @ParameterizedTest
    @CsvSource({"M, 0:1:N"})
    public void roverShouldMoveNorth(String command, String position){
        assertThat(rover.execute(command)).isEqualTo(position);
    }

    @ParameterizedTest
    @CsvSource({"MMM, 0:3:N"})
    public void roverShouldMove3StepsNorth(String command, String position){
        assertThat(rover.execute(command)).isEqualTo(position);
    }

    @ParameterizedTest
    @CsvSource({"MMML, 0:3:W"})
    public void roverShouldMove3StepsNorthAndRotateLeft(String command, String position){
        assertThat(rover.execute(command)).isEqualTo(position);
    }

    @ParameterizedTest
    @CsvSource({"MMMRM, 1:3:E"})
    public void roverShouldMove3StepsNorthAndRotateRight(String command, String position){
        assertThat(rover.execute(command)).isEqualTo(position);
    }

    @ParameterizedTest
    @CsvSource({"MMMMMMMMMMM, 0:0:N"})
    public void roverShouldMove10stepsAndReturnTo0(String command, String position){
        assertThat(rover.execute(command)).isEqualTo(position);
    }


    @Test
    public void stopWhenRoverHitsObstacle(){
        Coordinate obstacle = new Coordinate(0,3);
        Rovers.Grid grid = new Rovers.Grid(List.of(obstacle));
        Rovers rover = new Rovers(grid);
        assertThat(rover.execute("MMM")).isEqualTo("0:2:N");
    }

//    @ParameterizedTest
//    @CsvSource({"LLM, 0:0:S"})
//    public void roverShouldMoveSouth(String command, String position){
//        assertThat(rover.execute(command)).isEqualTo(position);
//    }


//    @Test
//    public void test(){
//        System.out.println(-1%11);
//    }
}


