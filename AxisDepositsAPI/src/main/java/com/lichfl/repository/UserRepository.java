package com.lichfl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lichfl.entity.CustomUserDetails;

@Repository
public interface UserRepository extends JpaRepository<CustomUserDetails, Long> {

	@Query(value = "SELECT * FROM user_details_api u WHERE u.user_name = ?1 and status=?2 and module_name = 'axisapi' ", nativeQuery = true)
	public CustomUserDetails findUserByUsername(String userName, String status);

}
