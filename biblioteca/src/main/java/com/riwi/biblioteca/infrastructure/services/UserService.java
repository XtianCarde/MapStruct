package com.riwi.biblioteca.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.riwi.biblioteca.api.dto.request.UserRequest;
import com.riwi.biblioteca.api.dto.response.LoansOfUserResponse;
import com.riwi.biblioteca.api.dto.response.ReservationOfUserResp;
import com.riwi.biblioteca.api.dto.response.UserResponse;
import com.riwi.biblioteca.domain.entities.User;
import com.riwi.biblioteca.domain.repositories.UserRepository;
import com.riwi.biblioteca.infrastructure.abstract_service.IUserService;
import com.riwi.biblioteca.infrastructure.mappers.LoansOfUserMapper;
import com.riwi.biblioteca.infrastructure.mappers.ReservationsOfUserMapper;
import com.riwi.biblioteca.infrastructure.mappers.UserMapper;
import com.riwi.biblioteca.util.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Autowired
    private final LoansOfUserMapper loansOfUserMapper;

    @Autowired
    private final ReservationsOfUserMapper reservationsOfUserMapper;

    @Override
    public UserResponse create(UserRequest rq) {
        User entityUser = this.userMapper.requestToEntity(rq);
        return this.userMapper.entityToResponse(this.userRepository.save(entityUser));
    }

    @Override
    public UserResponse get(Long id) {
        User userEntity = this.find(id);
        return this.userMapper.entityToResponse(userEntity);
    }

    @Override
    public UserResponse update(UserRequest rq, Long id) {
        User user = this.find(id);
        user = this.userMapper.requestToEntity(rq);
        user.setId(id);
        return this.userMapper.entityToResponse(this.userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        this.userRepository.delete(this.find(id));
    }

    @Override
    public Page<UserResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public LoansOfUserResponse loansOfUser(Long id){
        return this.loansOfUserMapper.loans(this.find(id));
    }
    
    @Override
    public ReservationOfUserResp reservationsOfUser(Long id) {
        return this.reservationsOfUserMapper.reservations(this.find(id));
    }

    public User find(Long id){
        return this.userRepository.findById(id).orElseThrow(() -> new BadRequestException("el id no esta en la base de datos"));
    }

}
