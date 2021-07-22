package com.ob.rover2;

import com.ob.rover.Direction;
import org.apache.commons.lang3.tuple.Pair;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rovers {

    String direction = "N";
    Coordinate coordinate = new Coordinate(0,0);
    private Grid grid;
    Map<String, Pair<String, String>> rotations = inits();

    public Rovers(Grid grid){
        this.grid = grid;
    }

    Direction edirection = Direction.NORTH;

    private static final Map<String, Pair<String, String>> inits(){
        Map<String, Pair<String, String>> map = new HashMap<>();
        map.put("N", Pair.of("W","E"));
        map.put("E", Pair.of("N","S"));
        map.put("W", Pair.of("S","N"));
        map.put("S", Pair.of("E","W"));
        return map;
    }

    public String execute(String rotationCommand) {
        char[] commands = rotationCommand.toCharArray();
        for(char command:commands){
            direction = determineDirection(String.valueOf(command), direction);
        }
        return coordinate.getX()+":"+coordinate.getY()+":"+direction;
    }

    private String determineDirection(String rotation, String currentDirection){
        if(rotation.equals("R")) {
            return rotations.get(currentDirection).getRight();
        }

        if(rotation.equals("L")) {
            return rotations.get(currentDirection).getLeft();
        }
        if(rotation.equals("M")) {
//            coordinate = move(currentDirection);
//            grid = new Grid();


            coordinate = grid.nextCoord(currentDirection, coordinate);



            return currentDirection;
        }
        return "N";
    }

    //concept of a grid
    //move this
    public static class Grid {
        private List<Coordinate> coordinates;
        public Grid(){}

        public Grid(List<Coordinate> coordinates){
            this.coordinates = coordinates;
        }


        public Coordinate nextCoord(String currentDirection, Coordinate coord) {

            if(currentDirection.equals("N"))
            {
                return new Coordinate(coord.getX() , coord.getY()+1);
            }
            if(currentDirection.equals("S"))
            {
                return new Coordinate(coord.getX(), coord.getY()-1);
            }
            if(currentDirection.equals("E"))
            {
                return new Coordinate(coord.getX()+1, coord.getY());
            }

            return new Coordinate(coord.getX()-1, coord.getY());

        }

//        private Coordinate isObstacle(Coordinate originalcoordinate, Coordinate finalCoordinate){
////            var cod = coordinates.contains(finalCoordinate) ? originalcoordinate : finalCoordinate;
////            System.out.println(coordinates.contains(finalCoordinate) ? originalcoordinate : finalCoordinate);
//            var bool =false;
//            if(coordinates.isEmpty()) {
//                var bool = coordinates.stream().anyMatch(cod -> cod.getX() == finalCoordinate.getX() && cod.getY() == finalCoordinate.getY());
//            }
//            if(bool){
//                return originalcoordinate;
//            }
//            return finalCoordinate;
////            return coordinates.contains(finalCoordinate) ? originalcoordinate : finalCoordinate;
//        }
    }

    private Coordinate move(String currentDirection) {

        if(currentDirection.equals("N"))
        {
            return new Coordinate(coordinate.getX() , coordinate.getY()+1);
        }
        if(currentDirection.equals("S"))
        {
            return new Coordinate(coordinate.getX(), coordinate.getY()-1);
        }
        if(currentDirection.equals("E"))
        {
            return new Coordinate(coordinate.getX()+1, coordinate.getY());
        }

        return new Coordinate(coordinate.getX()-1, coordinate.getY());

    }




}

//
//    private String determineDirection2(String movement, String currentDirection){
//        if(movement.equals("R")) {
//            return edirection.right().value();
//        }
//
//        if(movement.equals("L")) {
//            return edirection.left().value();
//        }
//        if(movement.equals("M")) {
//            coordinate = move(currentDirection);
//        }
//        return "N";
//    }