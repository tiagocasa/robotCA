package br.com.programacaoempar.robot.api;

import br.com.programacaoempar.robot.dto.Robot;
import com.sun.tools.attach.AttachOperationFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/rest")
public class RobotApi {

    @PostMapping("/mars/{strCommand}")
    ResponseEntity getPosition2(@PathVariable String strCommand){
            Robot robot = new Robot();
            if(robot.checkIfCommandIsValid(strCommand)){
                robot.moveRobot(strCommand);
                return new ResponseEntity(robot.finalPosition(), HttpStatus.OK);
            }else{
                return new ResponseEntity(HttpStatus.BAD_REQUEST.getReasonPhrase()+"\n",HttpStatus.BAD_REQUEST);
            }
        }
}

//curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM
//Saída esperada: (2, 0, S)

//curl -s --request POST http://localhost:8080/rest/mars/MML
//Saída esperada: (0, 2, W)

//curl -s --request POST http://localhost:8080/rest/mars/MML
//Saída esperada: (0, 2, W)

//curl -s --request POST http://localhost:8080/rest/mars/AAA
//Saída esperada: 400 Bad Request

//curl -s --request POST http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM
//Saída esperada: 400 Bad Request
// Nesse ultimo request eu fiz a logica para o Robo não andar para fora das limitações,
// então ao inves de Bad request ele vai ficar na distancia máxima (0,5,N)