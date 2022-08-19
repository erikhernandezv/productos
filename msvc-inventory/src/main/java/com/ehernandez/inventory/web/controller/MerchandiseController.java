package com.ehernandez.inventory.web.controller;

import com.ehernandez.inventory.domain.MerchandiseDTO;
import com.ehernandez.inventory.utility.Common;
import com.ehernandez.inventory.domain.service.MerchandiseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;

/**
 * @author Erik Darío Hernández Vásquez - erikdhv@gmail.com
 * @version 1.0
 */

@RestController
@RequestMapping("/mercancia")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.OPTIONS})
public class MerchandiseController {

    @Autowired(required=true)
    private MerchandiseService merchandiseService;

    @GetMapping("/all")
    @ApiOperation("Get all merchandises")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<MerchandiseDTO>> getAll(){
        System.out.println("LLega al controller /all");
        return new ResponseEntity<>(merchandiseService.getAll(), HttpStatus.OK);
    }

    /*@GetMapping("/gets/{name}/{fecha}/{user}")
    @ApiOperation("Get all merchandises to productName or fechIngreso or IdUser") //@DateTimeFormat(pattern = "") String
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Optional<List<Merchandise>>> getMerchandiseForNameFecIngUser(@PathVariable(name="name", required = false) String merchandiseName, @PathVariable(name="fecha", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") String merchandiseFechIngreso, @PathVariable(name="user", required = false) int merchandiseIdUser){
        System.out.println("LLega al controller /gets");
        return new ResponseEntity<>(merchandiseService.getNombreProductoOrFechaIngresoOrIdUsuario(merchandiseName,  LocalDate.parse(merchandiseFechIngreso, DateTimeFormatter.ofPattern("yyyy-MM-dd")), merchandiseIdUser), HttpStatus.OK);
    }*/

    @GetMapping("/getmercancia")
    @ApiOperation("Get all merchandises to productName or fechIngreso or IdUser")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Optional<List<MerchandiseDTO>>> getMerchandise(MerchandiseDTO merchandiseDTO){

        int user = Objects.isNull(merchandiseDTO.getIdUsuario())?0: merchandiseDTO.getIdUsuario();
        LocalDate fing = merchandiseDTO.getFechaIngreso();

        return new ResponseEntity<>(merchandiseService.getNombreProductoOrFechaIngresoOrIdUsuario(merchandiseDTO.getNombreProducto(),  fing, user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a product with an ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found"),
    })
    public ResponseEntity<MerchandiseDTO> getMercahndiseId(@ApiParam(value = "The id of the product", required = true, example = "7")
                                              @PathVariable("id") int merchandiseId) {
        return merchandiseService.getMerchandise(merchandiseId)
                .map(merchandise -> new ResponseEntity<>(merchandise, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Save and edit information of the merchandise")
    public ResponseEntity<?> save(@Valid @RequestBody MerchandiseDTO merchandiseDTO, BindingResult result){
        Map<String, Object> response = new HashMap<>();

        // Se validan errores de parametros segun sus validaciones definidas
        if (result.hasErrors()) {
            return Common.validates(result);
        }
        // Se procede a realizar el guardado o actualización y a su vez se capturan las excepciones si ocurren
        try{
            return new ResponseEntity<>(merchandiseService.save(merchandiseDTO), HttpStatus.OK);
        }catch(Exception e){
            response.put("message", "Failed to save or update merchandise from database!");
            response.put("error", e.getMessage().concat(": ").concat(e.getCause().getLocalizedMessage()));
            response.put("code", e.toString());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/delete/{id}")
    @ApiOperation("Delete all merchandise with a ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Merchandise not found"),
            @ApiResponse(code = 500, message = "Internal server error controller merchandise"),
    })
    public ResponseEntity delete(@PathVariable("id") int merchandiseId){
        try {
            if (merchandiseService.delete(merchandiseId)) {
                return new ResponseEntity(HttpStatus.OK);
            }else{
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
