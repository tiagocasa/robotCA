package br.com.programacaoempar.robot.dto;

public class Robot {
    private String robotFront = "N";
    private String actualPosition = "(0,0,N)";
    private int posX = 0;
    private int posY = 0;
    private int terrain[] = {5,5};


    public void moveRobot(String strCommand) {
        executeRobotMovement(strCommand);
    }

    public String finalPosition(){
        actualPosition = "("+posX+","+posY+","+robotFront+")\n";
        return actualPosition;
    }
    void executeRobotMovement(String strCommand){
        for (int i = 0; i < strCommand.length(); i++) {
            if (strCommand.charAt(i) == 'M') {
                moveStraight();
            }else if (strCommand.charAt(i) == 'L') {
                turnLeft();
            }else if(strCommand.charAt(i)=='R'){
                turnRight();
            }
        }
    }
    void moveStraight(){
        switch (robotFront){
            case "N":
                if(posY!=terrain[1]){
                    posY++;
                }
                break;
            case "S":
                if(posY!=0) {
                    posY--;
                }
                break;
            case "E":
                if(posX!=terrain[0]){
                    posX++;
                }
                break;
            case "W":
                if(posX!=0){
                    posX--;
                }
                break;
        }
    }
    void turnLeft(){
        switch (robotFront){
            case "N":
                robotFront = "W";
                break;
            case "S":
                robotFront = "E";
                break;
            case "E":
                robotFront = "N";
                break;
            case "W":
                robotFront = "S";
                break;
        }
    }
    void turnRight(){
        switch (robotFront){
            case "N":
                robotFront = "E";
                break;
            case "S":
                robotFront = "W";
                break;
            case "E":
                robotFront = "S";
                break;
            case "W":
                robotFront = "N";
                break;
        }
    }
    public Boolean checkIfCommandIsValid(String strCommand){
        for (int i = 0; i < strCommand.length(); i++) {
            switch (strCommand.charAt(i)){
                case 'M':
                case 'L':
                case 'R':
                    continue;
                default:
                    return false;
            }
        } return  true;
    }

}
