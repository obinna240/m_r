package com.ob.rover;

public enum Direction {

        NORTH("N", "W", "E"),
        EAST("E", "N", "S"),
        WEST("W", "S", "N"),
        SOUTH("S", "E", "W");

        private final String value;
        private final String left;
        private final String right;

        Direction(String value, String left, String right) {

            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Direction left(){
            return getWhichWayToRotate(this.left);
        }

        public Direction right(){
            return getWhichWayToRotate(this.right);
        }

        public String value() {
            return value;
        }

        private Direction getWhichWayToRotate(String right) {
            for (Direction direction : values()) {
                if (direction.value == right) {
                    return direction;
                }
            }
            return null;
        }

}
