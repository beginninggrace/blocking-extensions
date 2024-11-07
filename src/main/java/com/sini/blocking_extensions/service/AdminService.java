package com.sini.blocking_extensions.service;

import com.sini.blocking_extensions.dto.AdminRequest;
import com.sini.blocking_extensions.dto.AdminResponse;
import com.sini.blocking_extensions.dto.AdminSignupRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j(topic = "AdminService")
public class AdminService {

    public void signup(AdminSignupRequest adminSignupRequest) {

    }

    public AdminResponse login(AdminRequest adminRequest, HttpServletResponse response) {
        return null;
    }
}
