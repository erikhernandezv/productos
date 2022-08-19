package com.ehernandez.inventory.web.controller;

import com.ehernandez.inventory.domain.User;
import com.ehernandez.inventory.domain.service.UserService;
import com.ehernandez.inventory.utility.Common;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Erik Darío Hernández Vásquez - erikdhv@gmail.com
 * @version 1.0
 */

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @ApiOperation("Get all users")
    @ApiResponse(code=200, message="OK")
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation("Save information of the roles")
    public ResponseEntity<?> save(@Valid @RequestBody User user, BindingResult result){
        Map<String, Object> response = new HashMap<>();

        // Se validan errores de parametros segun sus validaciones definidas
        if (result.hasErrors()) {
            return Common.validates(result);
        }

        // Se procede a realizar el guardado o actualización y a su vez se capturan las excepciones si ocurren
        try{
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        }catch(Exception e){
            response.put("message", "Failed to save or update user from database!");
            response.put("error", e.getMessage().concat(": ").concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    @GetMapping("/delete/{id}")
    @ApiOperation("Delete all user with a ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal server error controller user"),
    })
    public ResponseEntity delete(@PathVariable("id") int roleId){
        try {
            if (userService.delete(roleId)) {
                return new ResponseEntity(HttpStatus.OK);
            }else{
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
