package hello;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ExampleService {


	// @RequestMapping(value = "/customers/list",
	//         consumes = "application/json",
	//         method = { RequestMethod.POST })
	// public @ResponseBody Object getCustomerList(
	//         ServletRequest req, ServletResponse res,
	//         @RequestBody String requestJson) throws Exception {
	// 	System.out.println("getCustomerList() called");
	// 	return "{'response' : 'success'}";
	// }
	
	    private static final String greetingTemplate = "Hello, %s!";
	    private final AtomicLong greetingCounter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		log.info(String.format(greetingTemplate, name));
			return new Greeting(greetingCounter.incrementAndGet(),
													String.format(greetingTemplate, name));
	}


	// @RequestMapping(value = "/employee/{employeeId}",
	//         consumes = "application/json",
	//         method = { RequestMethod.GET })
	// public @ResponseBody Object getEmployee(ServletRequest req,
	//         ServletResponse res,
	//         @PathVariable("employeeId") int employeeId)
	//         throws Exception {
	// 	System.out.println("getEmployee() called");
	// 	return "{'response' : 'success'}";
	// }
	//
	// @RequestMapping(value = "/employee",
	//         consumes = "application/json",
	//         method = { RequestMethod.POST })
	// public @ResponseBody Object insertEmployee(
	//         ServletRequest req, ServletResponse res,
	//         @RequestBody String requestJson) throws Exception {
	// 	System.out.println("insertEmployee() called");
	// 	return "{'response' : 'success'}";
	// }
	//
	// @RequestMapping(value = "/employee",
	//         consumes = "application/json",
	//         method = { RequestMethod.PUT })
	// public @ResponseBody Object updateEmployee(
	//         ServletRequest req, ServletResponse res,
	//         @RequestBody String requestJson) throws Exception {
	// 	System.out.println("updateEmployee() called");
	// 	return "{'response' : 'success'}";
	// }
	//
	// @RequestMapping(value = "/employee",
	//         consumes = "application/json",
	//         method = { RequestMethod.DELETE })
	// public @ResponseBody Object deleteEmployee(
	//         ServletRequest req, ServletResponse res,
	//         @RequestBody String requestJson) throws Exception {
	// 	System.out.println("deleteEmployee() called");
	// 	return "{'response' : 'success'}";
	// }
}
