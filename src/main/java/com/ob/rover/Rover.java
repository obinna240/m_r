package com.ob.rover;

public class Rover {


    public String execute(String commands) {
        String direction = "N";

        for(char com: commands.toCharArray()){
            direction = detectCommand(com, direction);
        }
        String finalDest = "0:0:"+direction;
        return finalDest;
    }

    private String detectCommand(char commands, String currentDirection) {

        if (commands == 'R'){
            return moveRight(currentDirection);
        }
        else if (commands == 'L'){
            return moveLeft(currentDirection);
        }
        else {
            throw new UnsupportedOperationException();
        }

    }

    private String moveRight(String cur_direction){
        if(cur_direction.equals("N")) {
            return "E";
        }
        else if(cur_direction.equals("E")) {
            return "S";
        }
        else if(cur_direction.equals("S")) {
            return "W";
        }
        else if(cur_direction.equals("W")) {
            return "N";
        }
        else {
            return "N";
        }
    }

    private String moveLeft(String cur_direction){
        String finalDest = "N";

//        if (month == null) {
//            return monthNumber;
//        }

        switch (cur_direction) {
            case "N":
                finalDest = "W";
                break;
            case "W":
                finalDest = "S";
                break;
            case "S":
                finalDest = "E";
                break;
            case "E":
                finalDest = "N";
                break;
            default:
                finalDest = "N";
                break;
        }

        return finalDest;
    }
}
