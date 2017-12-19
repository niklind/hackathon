package com.teliacompany.hackathon.birthday

import com.teliacompany.hackathon.birthday.model.CalcResult
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BirthdayApplicationTests {

	@Autowired
	private val restTemplate: TestRestTemplate? = null

	@Test
	fun contextLoads() {
		val body = restTemplate?.getForObject<CalcResult>("/birthtimeunitcalc/1987-11-15")
        Assert.assertNotNull(body);
	}
}
