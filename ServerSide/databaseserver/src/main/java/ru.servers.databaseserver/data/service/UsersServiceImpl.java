/*
 * Copyright 2018 Vladimir Balun
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.servers.databaseserver.data.service;

import lombok.extern.log4j.Log4j;
import ru.servers.databaseserver.data.dao.UsersRepository;
import ru.servers.databaseserver.data.dao.UsersRepositoryImpl;
import ru.servers.protocol.gameserverwithdatabaseserver.entity.User;
import ru.servers.protocol.gameserverwithdatabaseserver.service.UsersService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@Log4j
public class UsersServiceImpl extends UnicastRemoteObject implements UsersService {

    private static final long serialVersionUID = -6625973424919523876L;

    private UsersRepository usersRepository = new UsersRepositoryImpl();

    public UsersServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean addNewUser(User newUser) throws RemoteException {
        boolean addingResult = usersRepository.save(newUser);
        if (addingResult) {
            log.debug("New user was added. User: " + newUser.toString());
        } else {
            log.warn("User was not added. User: " + newUser.toString());
        }
        return addingResult;
    }

    @Override
    public boolean removeUserByEmail(String email, User newUser) throws RemoteException {
        boolean deletingResult = usersRepository.removeByEmail(email);
        if (deletingResult) {
            log.debug("User was deleted. User: " + newUser.toString());
        } else {
            log.warn("User was not deleted. User: " + newUser.toString());
        }
        return deletingResult;
    }

    @Override
    public boolean changeUserPasswordByEmail(String email, String newPassword) throws RemoteException {
        User user = usersRepository.findByEmail(email);
        if (user == null){
            log.warn("Email for user was not changed, user not found by email. Email: " + email);
            return false;
        }
        user.setPassword(newPassword);
        log.debug("Email for user with email: '" + email + "' was changed on '" + newPassword + "'");
        return usersRepository.updateByEmail(email, user);
    }

}
