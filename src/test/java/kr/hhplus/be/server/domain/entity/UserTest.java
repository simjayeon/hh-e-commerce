package kr.hhplus.be.server.domain.entity;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import kr.hhplus.be.server.interfaces.dto.response.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = TestcontainersConfiguration.class)
public class UserTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    @DisplayName("userDto userId,password,name,email에 null이 담기면 안된다.")
    void userDto_nullTest() {
        UserResponse userResponse = new UserResponse(null, null, null, null);
        Set<ConstraintViolation<UserResponse>> violations = validator.validate(userResponse);

        violations.forEach(i -> System.out.println(i.getMessage()));
        assertThat(violations.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("userDto userId,password,name,email가 비어있으면 안된다.")
    void userDto_emptyTest() {
        UserResponse userResponse = new UserResponse(null, "", null, "");
        Set<ConstraintViolation<UserResponse>> violations = validator.validate(userResponse);

        violations.forEach(i -> System.out.println(i.getMessage()));
        assertThat(violations.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("공백 에러 테스트")
    void userDto_blankTest() {
        UserResponse userResponse = new UserResponse(null, " ", null, " ");
        Set<ConstraintViolation<UserResponse>> violations = validator.validate(userResponse);

        violations.forEach(i -> System.out.println(i.getMessage()));
        assertThat(violations.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("이메일 정규식 테스트")
    void userDto_emailRegexTest() {
        UserResponse userResponse = new UserResponse(null, "1234", null, "failEmail");
        Set<ConstraintViolation<UserResponse>> violations = validator.validate(userResponse);

        violations.forEach(i -> System.out.println(i.getMessage()));
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("유저 검증 통과 테스트")
    void userDto_successTest() {
        UserResponse userResponse = new UserResponse(null, "Nature", null, "nature@email.com");
        Set<ConstraintViolation<UserResponse>> violations = validator.validate(userResponse);

        assertThat(violations.size()).isEqualTo(0);
    }
}