package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; //resources에 있는 템플릿 중 이름이 hello인 파일을 찾아라.
        //즉, 리턴값으로는 viewName을 찾게 되는 것임.
    }

    @GetMapping("hello-mvc") //주소값이 hello-mvc로 끝날 때 들어오는 controller
    //public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model)
        //param값으로 String name이 default로 true로 되어있기 때문에 웹에서 ?name= 가 들어가야만한다.
    public String helloMvc(@RequestParam("name") String name, Model model){
        //주소값에 들어온 문자열 파라미터는 name이라는 변수를 통해 attributeName으로 사용되어짐.
        model.addAttribute("name", name);
        return "hello-template";
    }
}
