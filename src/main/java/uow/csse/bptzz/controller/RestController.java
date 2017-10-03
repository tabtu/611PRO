package uow.csse.bptzz.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uow.csse.bptzz.model.Rest;


/**
 * Controller: RESTful Style SpringMVC
 * @attention	response should be json format
 * @attention	@RestController same name
 * @author 	Tab Tu
 * @date	Oct.3 2017
 * @version	1.0
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    /**
     * http://localhost:8080/mvc/page/rest
     *
     * @param id
     * @return
     */
    @RequestMapping(value="/user/{id}", method= RequestMethod.GET)
    public Rest get(@PathVariable("id") Integer id) {
        Rest rest = new Rest("GET", id);
        return rest;
    }

    @RequestMapping(value="/user/{id}", method=RequestMethod.POST)
    public Rest post(@PathVariable("id") Integer id) {
        Rest rest = new Rest("GET", id);
        return rest;
    }

    @RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
    public Rest put(@PathVariable("id") Integer id) {
        Rest rest = new Rest("GET", id);
        return rest;
    }

    @RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
    public Rest delete(@PathVariable("id") Integer id) {
        Rest rest = new Rest("GET", id);
        return rest;
    }
}
