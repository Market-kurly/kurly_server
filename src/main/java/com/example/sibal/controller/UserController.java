package com.example.sibal.controller;


import com.example.sibal.domain.User;
import com.example.sibal.dto.request.LoginResDto;
import com.example.sibal.dto.request.SignupRequestDto;
import com.example.sibal.dto.request.UserRequestDto;
import com.example.sibal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    //회원가입
    @PostMapping("/user/regist")
    public void userRegister(@RequestBody SignupRequestDto signupRequestDto){
        userService.registerUser(signupRequestDto);
    }

//    로그인
    @PostMapping("/user")
    public LoginResDto login(@RequestBody UserRequestDto userRequestDto) {
        String token = userService.createToken(userRequestDto);
        LoginResDto loginResDto = new LoginResDto();
        loginResDto.setJwtToken(token);

        User user = userService.findUser(userRequestDto);
        loginResDto.setUser(user);
        return loginResDto;

//        return userService.createToken();
    }


    // 아이디 중복 검사
    @GetMapping("/user/regist/{userName}")
    public ResponseEntity<Boolean> checkUsernameDuplicate(@PathVariable String userName){
        return ResponseEntity.ok(userService.checkUsernameDuplicate(userName));
    }


}