package com.sini.blocking_extensions.repository;

import com.sini.blocking_extensions.entity.CustomExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomExtensionRepository extends JpaRepository<CustomExtension, Long> {

    CustomExtension findByCustomExtensionName(String name);
}
