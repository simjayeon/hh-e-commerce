package kr.hhplus.be.server.infra.repository;

import kr.hhplus.be.server.domain.entity.User;
import kr.hhplus.be.server.domain.repository.IUserRepository;

public class UserRepositoryImpl implements IUserRepository {

    @Override
    public void save(User user) {}

    @Override
    public User findById(Long userId) {
       return null;
    }

}
