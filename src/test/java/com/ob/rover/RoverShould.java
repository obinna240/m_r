package com.ob.rover;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.core.Is.is;

public class RoverShould {
    private static Rover rover;

    @BeforeAll
    public static void init(){
        rover = new Rover();
    }

    //So given a starting position (0,0,N) 0, 0, facing North
    //then if i rotate right, then i should face East i.e. (0:0:E)
    //include an additional parameter to rotate twice
//    @Test
    @ParameterizedTest
    @CsvSource(delimiter = ',',
            value = {"R, 0:0:E",
                    "RR, 0:0:S",
            "RRR, 0:0:W",
            "LRLL, 0:0:S"})
    public void roverShouldRotate(String command, String position){
//        assertEquals(1,1);
        assertThat(rover.execute(command)).isEqualTo(position);

    }

    @Test
    public void roverShouldRotateRight(){
//        assertEquals(1,1);
        assertThat(rover.execute("R")).isEqualTo("0:0:E");

    }

    @Test
    public void roverShouldRotateRightMore(){
//        assertEquals(1,1);
        assertThat(rover.execute("RR")).isEqualTo("0:0:S");

    }
}
