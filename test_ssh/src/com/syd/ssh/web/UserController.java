package com.syd.ssh.web;

	
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syd.ssh.entity.User;
import com.syd.ssh.manager.UserManager;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name = "userManager")
	private UserManager userManager;
	

	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request) {
		
		request.setAttribute("userList", userManager.getAllUser());
		System.out.println("userController--"+userManager.getAllUser().toString());
		
		return "/index";
	}

	@RequestMapping("/getUser")
	public String getUser(String id, HttpServletRequest request) {

		request.setAttribute("user", userManager.getUser(id));

		return "/editUser";
	}

	@RequestMapping("/toAddUser")
	public String toAddUser() {
		return "/addUser";
	}

	@RequestMapping("/addUser")
	public String addUser(User user, HttpServletRequest request) {
		userManager.addUser(user);
		System.out.println("addUser"+user);
		return "redirect:/user/getAllUser";
	}

	@RequestMapping("/delUser")
	public void delUser(String id, HttpServletResponse response) {

		String result = "{\"result\":\"error\"}";

		if (userManager.delUser(id)) {
			result = "{\"result\":\"success\"}";
		}

		response.setContentType("application/json");

		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/updateUser")
	public String updateUser(User user, HttpServletRequest request) {
		System.out.println(user);
		if (userManager.updateUser(user)) {
			user = userManager.getUser(user.getId());
			request.setAttribute("user", user);
			return "redirect:/user/getAllUser";
		} else {
			return "/error";
		}
	}
    @RequestMapping("/json1")  
    public void returnUser(HttpServletRequest request,HttpServletResponse response) throws Exception{  
          
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        User u1 = new User();  
        u1.setUsername("u");  
        u1.setPassword("psw");
      
        //Json返回实体  
        JSONObject jsonObject = JSONObject.fromObject(u1);  
        //返给ajax请求  
        out.print(jsonObject);  
    }
    
    //接收前台传过来的字符串格式的json对象，在后台进行解析  
    @RequestMapping("/json2")  
    public void resolveJsonObject(HttpServletRequest request,HttpServletResponse response) throws IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
         
    	//解码  
        String n = URLDecoder.decode(request.getParameter("orderJson"),"UTF-8");  
        JSONObject jb =JSONObject.fromObject(n);   
        //将json格式的字符串转换为json对象，并取得该对象的“userName”属性值  
        System.out.println(jb);  
        out.print(jb); 
    } 
}
