package br.com.programacaoempar.robot.dto;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {

    Robot robot;
    @BeforeEach
    void Start()
    {
        robot = new Robot();
    }
    @Test
    void TestOne(){
        robot.moveRobot("MML");

        assertEquals("(0,2,W)",robot.finalPosition());
    }

    @Test
    void TestTwo(){
        robot.moveRobot("MMRMMRMM");
        assertEquals("(2,0,S)",robot.finalPosition());
    }

    @Test
    void TestThree(){
        robot.moveRobot("MML");
        assertEquals("(0,2,W)",robot.finalPosition());
    }

    @Test
    void TestFour(){
        robot.moveRobot("MML");
        assertEquals("(0,2,W)",robot.finalPosition());
    }

    @Test
    void TestInvalidCommand(){
        robot.moveRobot("AAAA");
        assertEquals("(0,0,N)",robot.finalPosition());
    }

    @Test
    void TestInvalidPosition(){
        robot.moveRobot("MMMMMMMMMMMMM");
        assertEquals("(0,5,N)",robot.finalPosition());
    }

}


// Comando para retornar a posicao final (loco)