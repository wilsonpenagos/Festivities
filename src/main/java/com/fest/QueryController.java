package com.fest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fest.persistence.FestivityParser;
import com.fest.persistence.SingletonMemoryPersistence;
import com.fest.status.FestStatusResponse;

@RestController
public class QueryController {

	private static FestivityParser parser = SingletonMemoryPersistence.getInstance();
    
    @RequestMapping("/getall")
    public RestQueryResponse getAll() {
    	String result = parser.getAll();
    	if (result.isEmpty()) {
    		return new RestQueryResponse(FestStatusResponse.NO_RESULTS.getCode(), FestStatusResponse.NO_RESULTS.getDescription(), "");
		}
        return new RestQueryResponse(FestStatusResponse.SUCCESS.getCode(), FestStatusResponse.SUCCESS.getDescription(), result);
    }
	
    @RequestMapping("/getby")
    public RestQueryResponse getBy(
    		@RequestParam(value="name", defaultValue="") String name,
    		@RequestParam(value="start", defaultValue="") String startDate,
    		@RequestParam(value="end", defaultValue="") String endDate,
    		@RequestParam(value="place", defaultValue="") String place) {
    	String result = parser.getBy(name, startDate, endDate, place);
    	if (result.isEmpty()) {
    		return new RestQueryResponse(FestStatusResponse.NO_RESULTS.getCode(), FestStatusResponse.NO_RESULTS.getDescription(), "");
		}
        return new RestQueryResponse(FestStatusResponse.SUCCESS.getCode(), FestStatusResponse.SUCCESS.getDescription(), result);
    }
    
    @RequestMapping("/create")
    public RestQueryResponse createFestivity(
    		@RequestParam(value="name", defaultValue="") String name,
    		@RequestParam(value="start", defaultValue="") String startDate,
    		@RequestParam(value="end", defaultValue="") String endDate,
    		@RequestParam(value="place", defaultValue="") String place) {
    	long result = parser.createFestivity(name, startDate, endDate, place);
    	if (result == 0) {
    		return new RestQueryResponse(FestStatusResponse.MISSING_DATA.getCode(), FestStatusResponse.MISSING_DATA.getDescription(), "||"+name+"||"+"||"+startDate+"||"+"||"+endDate+"||"+"||"+place+"||");
		}
        return new RestQueryResponse(FestStatusResponse.SUCCESS.getCode(), FestStatusResponse.SUCCESS.getDescription(), "");
    }
    
    @RequestMapping("/update")
    public RestQueryResponse updateFestivity(
    		@RequestParam(value="id", defaultValue="") long id,
    		@RequestParam(value="name", defaultValue="") String name,
    		@RequestParam(value="start", defaultValue="") String startDate,
    		@RequestParam(value="end", defaultValue="") String endDate,
    		@RequestParam(value="place", defaultValue="") String place) {
    	boolean result = parser.updateFestivity(id, name, startDate, endDate, place);
    	if (result) {
    		return new RestQueryResponse(FestStatusResponse.NO_RESULTS.getCode(), FestStatusResponse.NO_RESULTS.getDescription(), "");
		}
        return new RestQueryResponse(FestStatusResponse.SUCCESS.getCode(), FestStatusResponse.SUCCESS.getDescription(), "");
    }
    
}
