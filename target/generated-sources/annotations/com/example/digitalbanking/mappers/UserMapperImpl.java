package com.example.digitalbanking.mappers;

import com.example.digitalbanking.dtos.AppUserDTO;
import com.example.digitalbanking.dtos.RoleDTO;
import com.example.digitalbanking.entities.AppUser;
import com.example.digitalbanking.entities.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-08T16:37:44+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (JetBrains s.r.o.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public AppUserDTO toAppUserDTO(AppUser appUser) {
        if ( appUser == null ) {
            return null;
        }

        AppUserDTO appUserDTO = new AppUserDTO();

        appUserDTO.setUserId( appUser.getUserId() );
        appUserDTO.setUsername( appUser.getUsername() );
        appUserDTO.setEmail( appUser.getEmail() );

        appUserDTO.setRoles( mapRolesToStrings(appUser.getRoles()) );

        return appUserDTO;
    }

    @Override
    public List<AppUserDTO> toAppUserDTOs(List<AppUser> appUsers) {
        if ( appUsers == null ) {
            return null;
        }

        List<AppUserDTO> list = new ArrayList<AppUserDTO>( appUsers.size() );
        for ( AppUser appUser : appUsers ) {
            list.add( toAppUserDTO( appUser ) );
        }

        return list;
    }

    @Override
    public RoleDTO toRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setRoleId( role.getRoleId() );
        roleDTO.setRoleName( role.getRoleName() );

        return roleDTO;
    }

    @Override
    public List<RoleDTO> toRoleDTOs(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( roles.size() );
        for ( Role role : roles ) {
            list.add( toRoleDTO( role ) );
        }

        return list;
    }
}
