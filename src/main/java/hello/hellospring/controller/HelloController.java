package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello")// 이 어노테이션은 "/hello" URL에 대한 GET요청을 이 메서드가 처리하는것을 의미한다.
    public String hello(Model model) {// 클라이언트로부터 GET요청을 처리하며 반환타입은 String이다 hello(view)라는 문자열을 반환한다.
        model.addAttribute("data", "hello!!");// Model이라는 객체를 통해 data라는 이름으로 hello!!라는 문자열데이터를 출력한다.
        return "hello"; //사용될 뷰의 이름은 반환한다.
    } // 정리하면 URL로 들어오는 GET 요청을 처리하며 hello라는 뷰에 hello!!라는 데이터를 전달한다.

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) { // @RequestParam 어노테이션은 name에서 파라미터를 추출하고 name 변수에 매핑한다.
        model.addAttribute("name", name); //Model객체를 이용해 name이라는 이름으로 name변수값을 view로 전달한다.
        return "hello-template";
    } // 작동하는 원리 파라미터가 필요하므로 링크를 입력한다음 ?name="원하는 이름" 으로 파라미터를 주면된다.
}
