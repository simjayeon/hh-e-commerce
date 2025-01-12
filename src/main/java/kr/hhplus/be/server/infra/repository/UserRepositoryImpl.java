package kr.hhplus.be.server.infra.repository;

import kr.hhplus.be.server.domain.entity.User;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class UserRepositoryImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {

    public UserRepositoryImpl() {
        super(User.class);
    }

}
