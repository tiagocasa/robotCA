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

        assertEquals("(0,2,W)",robot.FinalPosition());
    }

    @Test
    void TestTwo(){
        robot.moveRobot("MMRMMRMM");
        assertEquals("(2,0,S)",robot.FinalPosition());
    }

    @Test
    void TestThree(){
        robot.moveRobot("MML");
        assertEquals("(0,2,W)",robot.FinalPosition());
    }

    @Test
    void TestFour(){
        robot.moveRobot("MML");
        assertEquals("(0,2,W)",robot.FinalPosition());
    }

    @Test
    void TestInvalidCommand(){
        robot.moveRobot("AAAA");
        assertEquals("(0,0,N)",robot.FinalPosition());
    }

    @Test
    void TestInvalidPosition(){
        robot.moveRobot("MMMMMMMMMMMMM");
        assertEquals("(0,5,N)",robot.FinalPosition());
    }

}


// Comando para retornar a posicao final (loco)