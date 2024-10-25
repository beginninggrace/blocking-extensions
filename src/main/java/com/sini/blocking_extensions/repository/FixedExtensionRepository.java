package com.sini.blocking_extensions.repository;

import com.sini.blocking_extensions.entity.FixedExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedExtensionRepository extends JpaRepository<FixedExtension, Long> {

    boolean findByExtensionName(String name);
}
