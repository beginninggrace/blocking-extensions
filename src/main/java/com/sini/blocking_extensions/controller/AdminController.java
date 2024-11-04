package com.sini.blocking_extensions.controller;

import com.sini.blocking_extensions.dto.AdminRequest;
import com.sini.blocking_extensions.dto.AdminResponse;
import com.sini.blocking_extensions.dto.AdminSignupRequest;
import com.sini.blocking_extensions.global.common.CommonResponse;
import com.sini.blocking_extensions.service.AdminService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users/admins")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/signup") @ResponseStatus(HttpStatus.CREATED)
    public void signup(@Valid @RequestBody AdminSignupRequest adminSignupRequest) {
        adminService.signup(adminSignupRequest);
    }


    @PostMapping("/login")
    public CommonResponse<AdminResponse> login(@RequestBody AdminRequest adminRequest, HttpServletResponse response) {
        return CommonResponse.ok(adminService.login(adminRequest, response));
    }
}
