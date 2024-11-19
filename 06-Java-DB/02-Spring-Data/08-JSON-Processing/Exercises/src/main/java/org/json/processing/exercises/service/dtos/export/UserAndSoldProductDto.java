package org.json.processing.exercises.service.dtos.export;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserAndSoldProductDto {

    @Expose
    private int usersCount;

    @Expose
    private Set<FullUserSoldJsonDto> users;

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public Set<FullUserSoldJsonDto> getUsers() {
        return users;
    }

    public void setUsers(Set<FullUserSoldJsonDto> users) {
        this.users = users;
    }
}
