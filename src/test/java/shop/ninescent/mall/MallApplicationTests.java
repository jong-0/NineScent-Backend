package shop.ninescent.mall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import shop.ninescent.mall.security.JwtTokenProvider;

@SpringBootTest
class MallApplicationTests {

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Test
	void contextLoads() {
		System.out.println("JWT Secret: " + jwtTokenProvider.getJwtSecret());
	}
}
