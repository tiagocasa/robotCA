package br.com.programacaoempar.robot.api;

import br.com.programacaoempar.robot.dto.Robot;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RobotApi {

    @PostMapping("/mars/{strCommand}")
    String getPosition (@PathVariable String strCommand){
        Robot robot = new Robot();
        robot.moveRobot(strCommand);
        return robot.FinalPosition();
    }
}

//curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM

//curl -s --request POST http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM