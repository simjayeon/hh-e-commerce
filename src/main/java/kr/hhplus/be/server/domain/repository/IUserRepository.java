package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.domain.entity.User;

public interface IUserRepository {

    void save(User user);

    User findById(Long userId);

}
