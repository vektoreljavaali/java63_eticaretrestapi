package com.vektorel.eticaretrestapi.restcontroller;

import com.vektorel.eticaretrestapi.repository.entity.Auth;
import com.vektorel.eticaretrestapi.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
@Api(value = "Kullanıcı yetkilendirme apisi")
public class AuthRestController {

    @Autowired
    AuthService authService;

    @PostMapping("/save")
    @ApiOperation(value = "yetki kayıt işlemi")
    public ResponseEntity<Void> save(long userid,int yetki){
        authService.save(Auth.builder()
                        .userid(userid)
                        .yetki(yetki)
                .build());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/dologin")
    public ResponseEntity<String> doLogin(String username, String password){
        String token = UUID.randomUUID().toString();
        return ResponseEntity.ok(token);
    }
}
