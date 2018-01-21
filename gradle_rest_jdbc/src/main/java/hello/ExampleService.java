package hello;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleService {
	@RequestMapping(value = "/employee/list",
	        consumes = "application/json",
	        method = { RequestMethod.POST })
	public @ResponseBody Object getEmployeeList(
	        ServletRequest req, ServletResponse res,
	        @RequestBody String requestJson) throws Exception {
		System.out.println("getEmployeeList() called");
		return "{'response' : 'success'}";
	}

	@RequestMapping(value = "/employee/{employeeId}",
	        consumes = "application/json",
	        method = { RequestMethod.GET })
	public @ResponseBody Object getEmployee(ServletRequest req,
	        ServletResponse res,
	        @PathVariable("employeeId") int employeeId)
	        throws Exception {
		System.out.println("getEmployee() called");
		return "{'response' : 'success'}";
	}

	@RequestMapping(value = "/employee",
	        consumes = "application/json",
	        method = { RequestMethod.POST })
	public @ResponseBody Object insertEmployee(
	        ServletRequest req, ServletResponse res,
	        @RequestBody String requestJson) throws Exception {
		System.out.println("insertEmployee() called");
		return "{'response' : 'success'}";
	}

	@RequestMapping(value = "/employee",
	        consumes = "application/json",
	        method = { RequestMethod.PUT })
	public @ResponseBody Object updateEmployee(
	        ServletRequest req, ServletResponse res,
	        @RequestBody String requestJson) throws Exception {
		System.out.println("updateEmployee() called");
		return "{'response' : 'success'}";
	}

	@RequestMapping(value = "/employee",
	        consumes = "application/json",
	        method = { RequestMethod.DELETE })
	public @ResponseBody Object deleteEmployee(
	        ServletRequest req, ServletResponse res,
	        @RequestBody String requestJson) throws Exception {
		System.out.println("deleteEmployee() called");
		return "{'response' : 'success'}";
	}
}
