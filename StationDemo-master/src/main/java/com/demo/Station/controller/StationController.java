package com.demo.Station.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Station.model.Station;
import com.demo.Station.repository.StationRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/station")
@Api(value="onlinestore", description="Operations pertaining to station")


@RestController
public class StationController {
	
	@Autowired
	StationRepository repository;
	
	
	@ApiOperation(value = "View a list of stations",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	
	@RequestMapping(value="/findAllStation", method=RequestMethod.GET)
    public ResponseEntity<List<Station>> findAllStation() {
		List<Station> stationList=repository.findAll();
        return new ResponseEntity<List<Station>>(stationList, HttpStatus.OK);
    }
    
        
    @RequestMapping(value="/insert", method=RequestMethod.POST)
    public String insert(@RequestBody Station station) { 
       repository.insert(station);
       return "inserted";
    }
    
    @RequestMapping(value="/delete", method=RequestMethod.DELETE)
    public String delete(@RequestParam(value="id") String id) { 
       repository.deleteById(id);
       return "Deleted";
    }
    
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(@RequestBody Station station) { 
       repository.update(station);
       return "Data updated";
    }
    
    @RequestMapping(value="/findByID",method=RequestMethod.GET)
    public Station findById(@RequestParam(value="id") String id) {
        return repository.findById(id);
    }
    
    @RequestMapping(value="/findByName",method=RequestMethod.GET)
    public Station findByName(@RequestParam(value="name") String name) {
        return repository.findByName(name);
    }
        
    @RequestMapping(value="/hasEnable", method=RequestMethod.GET)
    public List<Station> hasEnable()
    {
    	return repository.hasEnable();
    }
}
