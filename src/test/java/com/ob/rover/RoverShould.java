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
//    @Test
    @ParameterizedTest
    @CsvSource()
    public void roverShouldRotateRight(String command, String position){
//        assertEquals(1,1);
        assertThat(rover.execute("R")).isEqualTo("0:0:E");

    }

}
